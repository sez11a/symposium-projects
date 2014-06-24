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

<a href='<portlet:renderURL><portlet:param name="jspPage" value="/insults/view.jsp" /></portlet:renderURL>'>&lt; Back</a>


    <%
    List<String> insults = (List<String>)request.getAttribute("insults");

    for (int i=0; i<insults.size();i++) {

    %>

    <p>

      <%=insults.get(i) %>

    </p>

    <%

    }

    %>

    <a href='<portlet:renderURL><portlet:param name="jspPage" value="/insults/view.jsp" /></portlet:renderURL>'>&lt; Back</a>