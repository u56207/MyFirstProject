<%@page import="java.net.InetAddress"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body onload="display_ct();">
 <fmt:setBundle basename="build-version"/>
 <div id="footer">
			<div class="footerExpand">
					<div class="footerLogo">&nbsp;</div>
					<ul class="usefulLinks fusion">	
						<li>
						<a class="mainLink" target="_blank" href="http://cmstools.usis.us.equifax.com/pointscore/list.php">Pointscore Reference</a>
						<span>|</span>
						</li>
						<li>
						<a class="mainLink" target="_blank" href="https://siebelb2b.equifax.com/callcenter_enu/start.swe?SWECmd=Start&SWEHo=siebelb2b.equifax.com">Siebel</a>
						<span>|</span>
						</li>
						<li>
						<a class="mainLink" target="_blank" href="http://172.21.16.34:38080/jet2/manage/home.html">JET</a>
						<span>|</span>
						</li>
						<li>
						<a class="mainLink" target="_blank">CMS Process Document </a>
						<!-- Disabled the link for now -->
<!-- 						<a class="mainLink" target="_blank" href="http://docushare.atl.ec.equifax.com:8080/docushare/dsweb/View/Collection-20606" disabled="true">CMS Process Document </a> -->
						<span>|</span>
						</li>
						<li>
						<a class="mainLink" target="_blank" href="http://172.18.158.165:38081/DSListingTool/jsp/HomePage.jsp">Data Source Listing </a>
						</li>
					</ul>
		<div class="tagline">&nbsp;</div>
	</div>	
		</div>
</div>
<div class="bottomShadow"></div>
<p class="fusion" id="copyright"><script type="text/javascript"> var d = new Date(); document.write(d.getFullYear());</script> &copy; Equifax, Inc.  All rights reserved. 
<span style="margin-left: 7px">
	Build Number: <fmt:message key="application.sources.version" /> Build Date: <fmt:message key="application.build.date" />
	Application Version: <fmt:message key="application.version" />					
	Environment: ${applicationScope.ApplicationEnv}
	</br>Host: ${applicationScope.ApplicationHostName}
</span>					
<span style="margin-left: 7px" id="currentTime"></span>
</p>

<script type="text/javascript">
       function display_c()
       {
              var refresh=1000; // Refresh rate in milli seconds
              mytime=setTimeout('display_ct()',refresh)
       }

       function display_ct() 
       {
              var x = new Date();
              document.getElementById('currentTime').innerHTML = "Current Time: "+x;
              display_c();
       }
</script>

<div class="loadingOverlay" style="height: 1081px; display: none;">
	<p style="color:#ffffff">Please wait</p>
	<img src="<s:url value="/resources"/>/images/lightbox_preloader.gif" alt="Loading Please Wait">
</div>
<style>
#footer .footerExpand {
	width: 960px;
	height:31px;
	background:#FFF;
	padding-top:15px;
	border-top: 1px solid #EAEBEC;
	margin: 0 0 9px 18px !important;
}
</style>
</body>
</html>
