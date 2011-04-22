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

<portlet:renderURL var="addTaleURL">
	<portlet:param name="jspPage" value="/html/edit_talelet.jsp"></portlet:param>
</portlet:renderURL>

<c:if test='<%= PortletPermissionUtil.contains(permissionChecker, portletDisplay.getId(), "ADD_TALELET") %>'>
  <input type="button" value="<liferay-ui:message key="add-tale" />" onClick="location.href = '<%=addTaleURL.toString() %>';" />
</c:if>

<liferay-ui:search-container emptyResultsMessage="there-are-no-tales" delta="20">
	<liferay-ui:search-container-results>
	    <%
	
	    results = ActionUtil.getActiveTales(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd());
	    total = ActionUtil.getTaleletsCount(scopeGroupId);
	
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
      <portlet:param name="jspPage" value="/html/view_tale_starters.jsp" />
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