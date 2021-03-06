<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="footer">
    <span>© Copyright 2017, Sofast Company. All rights reserved</span>
</div>

    <div id="mask-loading" class="mask_loading" ng-if="loading" >
        <div>
            <img src='<c:url value="/image/gears.svg"/>'/>
            <div>Page is loading.</div>
        </div>
    </div>

<script type="application/javascript">
    function getFullRequestPath(context){
        return '${pageContext.request.contextPath}'+ context;
    }
    function formatPrice(num) {
        var num = (num || 0).toString(), result = '';
        while (num.length > 3) {
            result = ',' + num.slice(-3) + result;
            num = num.slice(0, num.length - 3);
        }
        if (num) { result = num + result; }
        return result;
    }
    function toPrice(num) {
        num = num.replace("$", "").trim();
        var replaceStr = ",";
        return Number(num.replace(new RegExp(replaceStr, 'gm'), ''));
    }
</script>
<script src="<c:url value='/js/jquery-1.11.3.min.js' />"></script>
<script src="<c:url value='/js/jquery.dataTables.min.js' />"></script>
<script src="<c:url value='/js/moment.min.js' />"></script>
<script src="<c:url value='/js/angular.min-1.5.7.js' />"></script>
<script src="<c:url value='/js/angular-animate.min.js' />"></script>
<script src="<c:url value='/js/angular-ui-router.min.js' />"></script>
<script src="<c:url value='/js/angular-confirm.min.js' />"></script>
<script src="<c:url value='/js/angular-moment.min.js' />"></script>
<script src="<c:url value='/js/app.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/ui-bootstrap-tpls-1.3.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/ui.js'/>"></script>
<script src="<c:url value='/js/angular-datatables.min.js' />"></script>
<script src="<c:url value='/js/service/account_info_service.js' />"></script>
<script src="<c:url value='/js/controller/account_info_controller.js' />"></script>
