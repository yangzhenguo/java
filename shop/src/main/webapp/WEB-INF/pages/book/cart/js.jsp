<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/10/16
  Time: 1:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="changeCardUrl" value="/changeCart"/>
<script>
    $(function () {
        $('input[type=number]').change(function () {
            var $input = $(this);
            if (confirm('Change the goods?')) {
                var count = $input.val()
                $.get('${changeCardUrl}', {
                    id: $input.data('id'),
                    count: count
                }, function (result) {
                    if (result.success) {
                        $('#count').text(result.count);
                        $input.data('count', count);
                        $('#price').text(result.price);
                    } else {
                        $input.val($input.data('count'))
                        alert(result.message)
                    }
                });
            } else {
                $input.val($input.data('count'))
            }
        });
        $('a.delete').click(function () {
            return confirm('Delete the goods?')
        });
    });
</script>