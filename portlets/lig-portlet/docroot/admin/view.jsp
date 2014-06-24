<%@include file="/init.jsp" %>

<portlet:actionURL name="addInsult" var="addInsultURL" />

<input type="button" value="<liferay-ui:message key="add-insult" />" onClick="location.href = '<%=addInsultURL.toString() %>';" />

  <liferay-ui:search-container emptyResultsMessage="there-are-no-statements" delta="20">
      <liferay-ui:search-container-results>
    <%
    List<Insult> tempResults = ActionUtil.getInsults(renderRequest);

    results = ListUtil.subList(tempResults, searchContainer.getStart(), searchContainer.getEnd());
    total = tempResults.size();

    pageContext.setAttribute("results", results);
    pageContext.setAttribute("total", total);
    %>
      </liferay-ui:search-container-results>

      <liferay-ui:search-container-row
    className="com.liferay.lig.model.Insult"
    keyProperty="insultId"
    modelVar="insult">

    <liferay-ui:search-container-column-text
        name="adjectiveOne"
        property="adjectiveOne"
        orderable="<%= true %>"
        />
    <liferay-ui:search-container-column-text
        name="directObject"
        property="directObject"
        orderable="<%= true %>"
        />
    <liferay-ui:search-container-column-text
      name="adjectiveTwo"
      property="adjectiveTwo"
      orderable="<%= true %>"
      />
    <liferay-ui:search-container-column-text
      name="objPreposition"
      property="objPreposition"
      orderable="<%= true %>"
      />
    <liferay-ui:search-container-column-jsp
        path="/admin/admin_actions.jsp"
        align="right"
        />
      </liferay-ui:search-container-row>

      <liferay-ui:search-iterator />

  </liferay-ui:search-container>