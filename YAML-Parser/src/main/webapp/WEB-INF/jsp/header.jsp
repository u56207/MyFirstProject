<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<c:set value="${pageContext.request.contextPath}" var="rootctx"/> <!-- Do not remove this variable. This is to set the root context for servlet.-->
<fmt:bundle basename="ui-dependency">
	<c:set var="basejqxdirectory"><fmt:message key="jqx.application.basedir" /></c:set>
	<c:set var="jqxdirpath"><fmt:message key="jqx.application.dir.location" ><fmt:param value = "${basejqxdirectory}" /></fmt:message></c:set>
</fmt:bundle>

	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=9" />
		<sec:csrfMetaTags />
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" /> <!-- HTTP 1.1 -->
        <meta http-equiv="Pragma" content="no-cache" /> <!-- HTTP 1.0 -->
        <meta http-equiv="Expires" content="0" /> <!-- Proxies -->
	  	<link href="<s:url value='/resources'/>/css/globalStyle.css" rel="stylesheet"/>
		<link rel="stylesheet" href="<s:url value='/resources'/>/css/jquery.ui.all.css"/>
		<link  href="<s:url value='/resources'/>/css/fusion_style.css" rel="stylesheet"/>	
		<link href="<s:url value="/resources" />/css/fonts.css" rel="stylesheet"/>
		<link href="<s:url value="/resources" />/css/fusion_cms.css" rel="stylesheet"/>	
		<link href="<s:url value="/resources" />/css/jqx_fusion_cms.css" rel="stylesheet"/>	
		<link href="<s:url value="/resources" />/css/cms_styles.css" rel="stylesheet"/>	
		<link href="<s:url value="/resources" />/css/cms_stats.css" rel="stylesheet"/>	
		<link href="<s:url value="/resources" />/css/style.css" rel="stylesheet"/>
		<link href="<s:url value="/resources" />/css/context_menu.css" rel="stylesheet"/>	
		<link href="<s:url value="/resources" />/css/dd.css" rel="stylesheet" type="text/css"/>
	    <link  href="<s:url value='/resources'/>/css/shadowbox.css" rel="stylesheet"/>
	    <!-- Bootstrap Core CSS -->
		<!--   <link href="<s:url value="/resources" />/css/bootstrap.min.css" rel="stylesheet"/>
		<link href="<s:url value="/resources" />/css/bootstrap-reset.css" rel="stylesheet"/>-->
		
		 <script src="<s:url value='/resources'/>/jquery/jquery-3.3.1.min.js" type="text/javascript"></script>	
		 <script src="<s:url value='/resources'/>/jquery/jquery-migrate-3.0.1.js" type="text/javascript"></script>		
		 
		
	    <script src="<s:url value='/resources'/>/jquery/ui/1.11.4/jquery-ui.min.js"></script>
	    <script src="<s:url value='/resources'/>/js/jquery.cookie.js"></script>
	    <script src="<s:url value='/resources'/>/jquery/ui/jquery.ui.core.js"></script>
		<script src="<s:url value='/resources'/>/jquery/ui/jquery.ui.widget.js"></script>
		<script src="<s:url value='/resources'/>/jquery/ui/jquery.ui.datepicker.js"></script>
		<%-- <script src="<s:url value='/resources'/>/js/validate.js" type="text/javascript"></script> --%>
		 <script src="<s:url value='/resources'/>/jquery/jquery.validate-1.19.0.js" type="text/javascript"></script>			
	    <script src="<s:url value='/resources'/>/js/shadowbox.js" type="text/javascript"></script>
	    <script type="text/javascript" language="javascript" src="<s:url value='/resources'/>/js/jquery.dataTables.min.js"></script>
		<!--<script src="js/dataTable_modified.js" type="text/javascript" language="javascript"></script>-->
		<script src="<s:url value='/resources'/>/js/fusion_functions.js" type="text/javascript" language="javascript"></script>
	    <script src="<s:url value="/resources" />/js/fusion_cms.js" type="text/javascript" language="javascript"></script>
        <script src="<s:url value='/resources'/>/js/jquery.alerts.js" type="text/javascript"></script>
        <link href="<s:url value="/resources" />/css/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />    
	    <link href="<s:url value="/resources" />/css/select2.min.css" rel="stylesheet" />
		<script src="<s:url value="/resources" />/js/select2.min.js"  type="text/javascript"></script>
		<script src="<s:url value='/resources'/>/js/jquery.dd.min.js" type="text/javascript"></script>
		<script src="<s:url value="/resources"/>/js/cms_project_processName_validation.js"type="text/javascript" language="javascript"></script>
		<script src="<s:url value="/resources"/>/js/cms_csrf_handler.js" type="text/javascript"></script>
		
		

	    <title>T Mobile HAProxy Config UI</title>
	    <meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
	</head>
	<body>
<div class="clearfix" id="wrapper">
    <div id="header">
	<!-- Header --> 
	<div class="logoBlock">
		<a class="logo" href="http://www.equifax.com/home/en_us"></a>
		<div class="clear"></div>
		<div class="headerTitle">
			<h1><a href="#" style="cursor:default;">Fusion ${applicationScope.ApplicationEnv}</a></h1>
		</div>
	</div>	
	</div>
	<!-- Header  ends-->    