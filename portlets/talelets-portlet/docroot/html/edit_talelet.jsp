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

<%@include file="/html/init.jsp" %>

<portlet:renderURL windowState="normal" var="backURL">
  <portlet:param name="jspPage" value="/html/view.jsp"></portlet:param>
</portlet:renderURL>

<liferay-ui:header
  backURL="<%= backURL %>"
  title="Talelets"
/>

<%

Talelet talelet = (Talelet)request.getAttribute(WebKeys.TALELET_ENTRY);
String redirect = ParamUtil.getString(request, "redirect");
long taleParentId = ParamUtil.getLong(request, "taleParentId");
long taleStarterId = ParamUtil.getLong(request, "taleStarterId");
String taleType = ParamUtil.getString(request, "taleType");

if (taleParentId > 0) {
	Talelet taleParent = ActionUtil.getTalelet(taleParentId);
	talelet.setTaleParentId(taleParent.getTaleId());
	talelet.setTaleOrder(taleParent.getTaleOrder() + 1);
}

if (taleStarterId > 0) {
	talelet.setTaleStarterId(taleStarterId);
}

long resourcePrimKey = BeanParamUtil.getLong(talelet, request, "taleId");
int status = BeanParamUtil.getInteger(talelet, request, "status", WorkflowConstants.STATUS_DRAFT);

%>

  <portlet:actionURL name="updateTalelet" var="updateTaleletURL">
    <portlet:param name="redirect" value="<%= redirect %>" />
  </portlet:actionURL>
  <portlet:renderURL var="cancelURL"><portlet:param name="jspPage" value="/html/view.jsp" /></portlet:renderURL>

<aui:form name="fm" action="<%= updateTaleletURL.toString() %>" onSubmit='<%=renderResponse.getNamespace() + "updateTalelet();" %>' method="post">

  <aui:fieldset>

  <aui:model-context bean="<%= talelet %>" model="<%= Talelet.class %>" />

  <c:if test="<%= talelet != null %>">
    <aui:workflow-status id="<%= String.valueOf(resourcePrimKey) %>" status="<%= status %>" />
  </c:if>

    <aui:input name="taleId" type="hidden" />
    <aui:input name="taleParentId" type="hidden" />
    <aui:input name="taleStarterId" type="hidden" />
    <aui:input name="taleOrder" type="hidden" />
    <aui:input name="taleType" type="hidden" value="<%=taleType %>" />

      <liferay-ui:error
        key="talelet-title-required"
        message="talelet-title-required" />

    <aui:input name="taleTitle" first="true" autoFocus="true" size="45" />
    
     <aui:field-wrapper label="content">
			<liferay-ui:input-editor width="100%" />

			<aui:input name="content" type="hidden" />
	</aui:field-wrapper>
	
<%--	<aui:input name="content" type="textarea" />  --%>

    <aui:input name="categories" type="assetCategories" />

    <aui:input name="tags" type="assetTags" />

    <aui:button-row>

      <aui:button type="submit" />

      <aui:button
       type="cancel"
        value="Cancel"
        onClick="<%=cancelURL %>"
      />


    </aui:button-row>

  </aui:fieldset>

</aui:form>

<aui:script>
	function <portlet:namespace />updateTalelet() {
		document.<portlet:namespace />fm.<portlet:namespace />content.value = window.<portlet:namespace />editor.getHTML();
	}
</aui:script>