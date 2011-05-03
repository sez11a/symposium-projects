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
	Talelet taleStarter = (Talelet) request.getAttribute(WebKeys.TALELET_ENTRY);
	Talelet tale = ActionUtil.getTalelet(taleStarter.getTaleParentId());
	String redirect = ParamUtil.getString(request, "redirect");
%>

<portlet:renderURL windowState="normal" var="backURL">
	<portlet:param name="jspPage" value="/html/view_tale_starters.jsp"></portlet:param>
	<portlet:param name="resourcePrimKey" value="<%=String.valueOf(tale.getTaleId()) %>" />
</portlet:renderURL>

<liferay-ui:header backURL="<%= backURL %>" title="Talelets" />

<%
User taleAuthor = UserLocalServiceUtil.getUser(tale.getUserId());
User taleStarterAuthor = UserLocalServiceUtil.getUser(taleStarter.getUserId());
%>

<table width="100%" border="0">
<tr>
<td valign="top">
<img alt="<liferay-ui:message key="user-portrait" />" class="user-profile-image" src="<%= taleAuthor.getPortraitURL(themeDisplay) %>" /><br>
<%=tale.getAuthorName() %>
</td>

<td valign="top">
<h1><%=tale.getTaleTitle() %></h1>
<p><%=tale.getContent() %></p>
</td>

</tr>
<tr>
<td valign="top">
<img alt="<liferay-ui:message key="user-portrait" />" class="user-profile-image" src="<%= taleStarterAuthor.getPortraitURL(themeDisplay) %>" /><br>
<%=taleStarter.getAuthorName() %>
</td>

<td valign="top">
<h2><%=taleStarter.getTaleTitle() %></h2>
<p><%=taleStarter.getContent() %></p>
</td>

</tr>

</table>

<liferay-ui:search-container emptyResultsMessage="there-are-no-tales" delta="20">
	<liferay-ui:search-container-results>
	    <%
	
	    results = ActionUtil.getTalelets(taleStarter.getTaleId());
	    total = results.size();
	
	    pageContext.setAttribute("results", results);
	    pageContext.setAttribute("total", total);
	    
	    %>
    </liferay-ui:search-container-results>
    
    <liferay-ui:search-container-row
    	className="com.liferay.talelets.service.model.Talelet"
    	keyProperty="taleId"
    	modelVar="talelet">
    	
    <liferay-ui:search-container-column-text name="author">
    
    <%
    User user2 = UserLocalServiceUtil.getUser(talelet.getUserId());
    
    %>
    
    <img alt="<liferay-ui:message key="user-portrait" />" class="user-profile-image" src="<%= user2.getPortraitURL(themeDisplay) %>" /><br>
    <%=talelet.getAuthorName() %>
    
    </liferay-ui:search-container-column-text>
    
    <liferay-ui:search-container-column-text name="talelet">
    	
    	<h2><%=talelet.getTaleTitle() %></h2>
    	<p><%=talelet.getContent() %></p>
    	
    </liferay-ui:search-container-column-text>
     
   
    <liferay-ui:search-container-column-jsp
        path="/html/tale_actions.jsp"
        align="right"
        />  
    
    </liferay-ui:search-container-row>
    
    <liferay-ui:search-iterator />

</liferay-ui:search-container>

<%
List talelets = (List)pageContext.getAttribute("results");
Talelet lastTalelet = taleStarter;
if (talelets.size()>0) {
   lastTalelet = (Talelet)talelets.get(talelets.size()-1);
} 
%>

<portlet:renderURL var="addTaleletURL">
	<portlet:param name="jspPage" value="/html/edit_talelet.jsp"></portlet:param>
	<portlet:param name="taleParentId" value="<%=String.valueOf(lastTalelet.getTaleId()) %>" />
	<portlet:param name="taleStarterId" value="<%=String.valueOf(taleStarter.getTaleId()) %>" />
	<portlet:param name="taleType" value="talelet" />
</portlet:renderURL>

<c:if test='<%= PortletPermissionUtil.contains(permissionChecker, portletDisplay.getId(), "ADD_TALELET") %>'>
  <input type="button" value="<liferay-ui:message key="add-talelet" />" onClick="location.href = '<%=addTaleletURL.toString() %>';" />
</c:if>

<liferay-ui:ratings className="<%= Talelet.class.getName() %>"
    classPK="<%= taleStarter.getTaleId() %>" type="stars" />

<liferay-ui:panel-container extended="<%= false %>"
		id="taleletCommentsPanelContainer" persistState="<%= true %>">
	
		<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>"
	        id="taleletCommentsPanel" persistState="<%= true %>"
	        title='<%= LanguageUtil.get(pageContext, "comments") %>'>
	
			<portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL" />
	
			<liferay-ui:discussion className="<%= Talelet.class.getName() %>"
	            classPK="<%= taleStarter.getTaleId() %>"
	            formAction="<%= discussionURL %>" formName="fm2"
	            ratingsEnabled="<%= true %>" redirect="<%= currentURL %>"
	            subject="<%= taleStarter.getTaleTitle() %>"
	            userId="<%= taleStarter.getUserId() %>" />
	
		</liferay-ui:panel>
	
</liferay-ui:panel-container>