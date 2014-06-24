<%
/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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
%>

<%@include file="/init.jsp" %>

<portlet:actionURL name="generateInsults" var="generateInsultsURL" />

<aui:form name="fm" action="<%= generateInsultsURL.toString() %>" method="post">

      <liferay-ui:error
        key="please-enter-number"
        message="please-enter-number" />

  <aui:input name="numberGenerate" />

  <aui:button-row>

    <aui:button type="submit" value="Generate!"/>

  </aui:button-row>

</aui:form>