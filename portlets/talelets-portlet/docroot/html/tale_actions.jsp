<%--
/**
* Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
--%>

<%@include file = "/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Talelet myTalelet = (Talelet)row.getObject();
long groupId = myTalelet.getGroupId();
String name = Talelet.class.getName();
String primKey = String.valueOf(myTalelet.getPrimaryKey());
%>

<liferay-ui:icon-menu>
  
  <c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.UPDATE) %>">
    <portlet:renderURL var="editURL">
      <portlet:param name="resourcePrimKey" value="<%=primKey %>" />
      <portlet:param name="jspPage" value="/html/edit_talelet.jsp" />
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit" url="<%=editURL.toString() %>" />
  </c:if>
  
  <c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.DELETE) %>">
    <portlet:actionURL name="deleteTalelet" var="deleteURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>

    <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
  </c:if>

  <c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.PERMISSIONS) %>">
    <liferay-security:permissionsURL
      modelResource="<%= Talelet.class.getName() %>"
      modelResourceDescription="<%= myTalelet.getTaleTitle() %>"
      resourcePrimKey="<%= primKey %>"
      var="permissionsURL"
    />

    <liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
  </c:if>
</liferay-ui:icon-menu>