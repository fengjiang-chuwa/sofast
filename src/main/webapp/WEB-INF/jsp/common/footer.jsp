<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page_footer">
    &copy; Copyright 2016-2017, California Science And Technology University. All rights reserved (Release Date: 10/20/2017)
</div>

<div>
    <div id="mask-loading" class="mask-loading" ng-if="loading" style="background-color: rgba(0, 0, 0, 0.5);">
        <div><img src='<c:url value="/webresource/img/gears.svg"/>'/>
            <div>Page is loading.</div></div>
    </div>
</div>

<script type="application/javascript">
    function getFullRequestPath(context){
        return '${pageContext.request.contextPath}'+ '/mvc' + context;
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

</script>

<script src="<c:url value='/webresource/js/jquery-1.11.3.min.js' />"></script>
<script src="<c:url value='/webresource/js/jquery.dataTables.min.js' />"></script>
<script src="<c:url value='/webresource/js/angular.min-1.5.7.js' />"></script>
<script src="<c:url value='/webresource/js/angular-animate.min.js' />"></script>
<script src="<c:url value='/webresource/js/angular-ui-router.min.js' />"></script>
<script src="<c:url value='/webresource/js/angular-confirm.min.js' />"></script>
<script src="<c:url value='/webresource/js/app.js' />"></script>
<script type="text/javascript" src="<c:url value='/webresource/js/ui-bootstrap-tpls-1.3.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/webresource/js/ui.js'/>"></script>
<script src="<c:url value='/webresource/js/angular-datatables.min.js' />"></script>
<script src="<c:url value='/webresource/js/service/account_info_service.js' />"></script>
<script src="<c:url value='/webresource/js/service/trn_account_info_service.js' />"></script>
<script src="<c:url value='/webresource/js/controller/account_info_controller.js' />"></script>
<script src="<c:url value='/webresource/js/controller/trn_account_info_controller.js' />"></script>