package com.jc.ssm.util;

import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class Pagination {
	/**
	 * 产生分页 @Title: genPagination @Description: TODO @param @param
	 * pageNo @param @param pageSize @param @param
	 * rowCount @param @return @return String @throws
	 */
	public static String genPagination(int pageNo, int pageSize, int rowCount, HttpServletRequest request, String path) {
		if (rowCount <= 0 || rowCount <= pageSize) {
			return null;
		}
		int totalPage = (int) Math.ceil(rowCount * 1.0 / pageSize);
		int firstPage = pageNo - 2;
		firstPage = firstPage < 1 ? 1 : firstPage;
		int lastPage = firstPage + 4;
		lastPage = lastPage > totalPage ? totalPage : lastPage;
		pageNo = pageNo > lastPage ? lastPage : pageNo;

		String queryString = null;
		if (request.getMethod().equals("POST")){
			queryString = genPageLink(request);
		} else {
			queryString = request.getQueryString();
		}
		if (queryString == null) {
			queryString = "pageNo=1";
		}
		if (!queryString.contains("pageNo")) {
			queryString += "&pageNo=1";
		}
		String link  = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + path;
		String regex = "pageNo=(\\d+)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(queryString);
		if (matcher.find()){
			queryString = matcher.replaceAll("pageNo=pageNo");
		}
		link = link + "?" + queryString;
		String result = "<ul class='pagination pagination-sm no-margin pull-right'>";
		if (pageNo > 1) {
			result += "<li class='paginate_button previous'><a href='" + link.replaceAll("pageNo=pageNo", "pageNo=" + (pageNo - 1)) + "'>上一页</a></li>";
		} else {
			result += "<li class='paginate_button previous disabled'><a href='javascript:void(0)'>上一页</a></li>";
		}
		for (int i = 1; i <= lastPage; i++) {
			if (i == pageNo) {
				result += "<li class='paginate_button active'><a href='" + link.replaceAll("pageNo=pageNo", "pageNo=" + i) + "'>" + i + "</a></li>";
			} else {
				result += "<li class='paginate_button'><a href='" + link.replaceAll("pageNo=pageNo", "pageNo=" + i) + "'>" + i + "</a></li>";
			}
		}
		if (pageNo == totalPage) {
			result += "<li class='paginate_button next disabled'><a href='javascript:void(0)'>下一页</a></li>";
		} else {
			result += "<li class='paginate_button next'><a href='" + link.replaceAll("pageNo=pageNo", "pageNo=" + (pageNo + 1)) + "'>下一页</a></li>";
		}
		result += "</ul>";
		return result;
	}

	public static String genPageLink(HttpServletRequest request) {
		String result = null;
		Enumeration<?> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			String paramValue = request.getParameter(paramName);
			if (result == null) {
				result = paramName + "=" + paramValue;
			} else {
				result += "&" + paramName + "=" + paramValue;
			}
		}
		return result;
	}
}
