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

<portlet:renderURL windowState="normal" var="backURL">
	<portlet:param name="jspPage" value="/html/view.jsp"></portlet:param>
</portlet:renderURL>

<liferay-ui:header backURL="<%= backURL %>" title="Tale Starters" />

<%
	Talelet tale = (Talelet) request.getAttribute(WebKeys.TALELET_ENTRY);
	String redirect = ParamUtil.getString(request, "redirect");
%>

<h1><%=tale.getTaleTitle()%></h1>
<h2><liferay-ui:message key="author" />: <%=tale.getAuthorName() %></h2>

<p>
<%=tale.getContent() %>
</p>

<liferay-ui:ratings className="<%= Talelet.class.getName() %>"
    classPK="<%= tale.getTaleId() %>" type="stars" />
    
<portlet:renderURL var="addTaleURL">
	<portlet:param name="jspPage" value="/html/edit_talelet.jsp"></portlet:param>
	<portlet:param name="taleParentId" value="<%=String.valueOf(tale.getTaleId()) %>" />
	<portlet:param name="taleType" value="taleStarter" />
</portlet:renderURL>

<c:if test='<%= PortletPermissionUtil.contains(permissionChecker, portletDisplay.getId(), "ADD_TALELET") %>'>
  <input type="button" value="<liferay-ui:message key="add-tale-starter" />" onClick="location.href = '<%=addTaleURL.toString() %>';" />
</c:if>

<table width="100%" border="0">
	<tr>
	<td>
		<liferay-ui:search-container emptyResultsMessage="there-are-no-tales" delta="20">
	<liferay-ui:search-container-results>
	    <%
	
	    results = ActionUtil.getTaleStartersByDate(tale.getTaleId(), searchContainer.getStart(), searchContainer.getEnd());
	    total = results.size();
	
	    pageContext.setAttribute("results", results);
	    pageContext.setAttribute("total", total);
	    
	    %>
    </liferay-ui:search-container-results>
    
    <liferay-ui:search-container-row
    	className="com.liferay.talelets.service.model.Talelet"
    	keyProperty="taleId"
    	modelVar="talelet">

    <%
    	String summary = StringUtil.shorten(talelet.getContent(), 200);
    %>
    
    <portlet:renderURL windowState="maximized" var="rowURL">
      <portlet:param name="jspPage" value="/html/view_talelets.jsp" />
      <portlet:param name="resourcePrimKey" value="<%= String.valueOf(talelet.getTaleId()) %>" />
      <portlet:param name="redirect" value="<%= currentURL %>" />
    </portlet:renderURL>
    
    <liferay-ui:search-container-column-text href="<%=rowURL %>"
        name="tale-title"
        property="taleTitle"
     />
    
    <liferay-ui:search-container-column-text name="tale-opener">
    	
    	<%=summary %>
    	
    </liferay-ui:search-container-column-text>
     
   
    <liferay-ui:search-container-column-jsp
        path="/html/tale_actions.jsp"
        align="right"
        />  
    
    </liferay-ui:search-container-row>
    
    <liferay-ui:search-iterator />

</liferay-ui:search-container>
		
	</td>
	<td>
	
		<liferay-ui:panel-container extended="<%= false %>"
		id="taleletCommentsPanelContainer" persistState="<%= true %>">
	
		<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>"
	        id="taleletCommentsPanel" persistState="<%= true %>"
	        title='<%= LanguageUtil.get(pageContext, "comments") %>'>
	
			<portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL" />
	
			<liferay-ui:discussion className="<%= Talelet.class.getName() %>"
	            classPK="<%= tale.getTaleId() %>"
	            formAction="<%= discussionURL %>" formName="fm2"
	            ratingsEnabled="<%= true %>" redirect="<%= currentURL %>"
	            subject="<%= tale.getTaleTitle() %>"
	            userId="<%= tale.getUserId() %>" />
	
		</liferay-ui:panel>
	
		</liferay-ui:panel-container>
	</td>
	</tr>
</table>

