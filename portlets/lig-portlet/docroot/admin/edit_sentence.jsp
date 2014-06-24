<%@include file="/init.jsp" %>
<jsp:useBean id="insult" type="com.liferay.lig.model.Insult" scope="request" />

  <portlet:actionURL name="updateInsult" var="updateInsultURL"/>
  <portlet:renderURL var="cancelURL"><portlet:param name="jspPage" value="/admin/view.jsp" /></portlet:renderURL>

<aui:form name="fm" action="<%= updateInsultURL.toString() %>" method="post">

  <aui:fieldset>

    <aui:input name="resourcePrimKey" value="<%=insult.getInsultId() %>" type="hidden" />

    <h1>You</h1>

      <liferay-ui:error
        key="adjective-required"
        message="adjective-required" />
    <aui:input name="adjectiveOne" value="<%=insult.getAdjectiveOne() %>" first="true" autoFocus="true" size="45" />

    <liferay-ui:error
        key="noun-required"
        message="noun-required" />
    <aui:input name="directObject" value="<%=insult.getDirectObject() %>" size="45" />

    <h1>of</h1>

    <liferay-ui:error
        key="adjective-required"
        message="adjective-required" />
    <aui:input name="adjectiveTwo" value="<%=insult.getAdjectiveTwo() %>" size="45" />

    <liferay-ui:error
        key="noun-required"
        message="noun-required" />
    <aui:input name="objPreposition" value="<%=insult.getObjPreposition() %>" size="45" />

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