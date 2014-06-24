<%
/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
%>

<%@include file="/init.jsp" %>


<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Insult myInsult = (Insult)row.getObject();
long groupId = themeDisplay.getLayout().getGroupId();
String name = Insult.class.getName();
String primKey = String.valueOf(myInsult.getInsultId());
%>

<liferay-ui:icon-menu>

  <c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.UPDATE) %>">
    <portlet:actionURL name="editInsult" var="editURL">
      <portlet:param name="resourcePrimKey" value="<%=primKey %>" />
    </portlet:actionURL>

    <liferay-ui:icon image="edit" message="Edit" url="<%=editURL.toString() %>" />
  </c:if>

  <c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.DELETE) %>">
    <portlet:actionURL name="deleteInsult" var="deleteURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>

    <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
  </c:if>

  <c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.PERMISSIONS) %>">
    <liferay-security:permissionsURL
      modelResource="<%= Insult.class.getName() %>"
      modelResourceDescription="<%= "You " + myInsult.getAdjectiveOne() + " " + myInsult.getDirectObject() + " of " + myInsult.getAdjectiveTwo() + " " + myInsult.getObjPreposition() %>"
      resourcePrimKey="<%= primKey %>"
      var="permissionsURL"
    />

    <liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
  </c:if>
</liferay-ui:icon-menu>