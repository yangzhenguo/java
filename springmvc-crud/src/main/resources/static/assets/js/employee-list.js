/**
 * Created by Sam on 2019/11/25.
 */
$(function () {
    $('.delete').click(function () {
        if (confirm('Delete the item?')) {
            var uid = $(this).data('hid');
            $.ajax({
                url: '/employee/' + uid,
                method: 'DELETE',
                success: function (data) {
                    if (data) {
                        location.reload();
                    }
                }
            })
        }
    })
})