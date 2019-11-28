/**
 * Created by Sam on 2019/11/25.
 */
$(function () {
    $('.delete').click(function () {
        if (confirm('Delete the item?')) {
            console.log($(this).attr('href'))
            $('form').attr('action', $(this).attr('href')).submit()
            /*
            $.ajax({
                url: '/employee/' + uid,
                method: 'DELETE',
                success: function (data) {
                    if (data) {
                        location.reload();
                    }
                }
            })
            */
        }
        return false;
    })
})