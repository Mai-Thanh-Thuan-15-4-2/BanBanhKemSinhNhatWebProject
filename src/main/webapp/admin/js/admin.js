$(document).ready(function() {
    "use strict"; // start of use strict

    /*==============================
    Menu
    ==============================*/
    $('.header__btn').on('click', function() {
        $(this).toggleClass('header__btn--active');
        $('.header').toggleClass('header--active');
        $('.sidebar').toggleClass('sidebar--active');
    });

    /*==============================
    Filter
    ==============================*/
    $('.filter__item-menu li').each(function() {
        $(this).attr('data-value', $(this).text().toLowerCase());
    });

    $('.filter__item-menu li').on('click', function() {
        var text = $(this).text();
        var item = $(this);
        var id = item.closest('.filter').attr('id');
        $('#' + id).find('.filter__item-btn input').val(text);
    });

    /*==============================
    Tabs
    ==============================*/
    $('.profile__mobile-tabs-menu li').each(function() {
        $(this).attr('data-value', $(this).text().toLowerCase());
    });

    $('.profile__mobile-tabs-menu li').on('click', function() {
        var text = $(this).text();
        var item = $(this);
        var id = item.closest('.profile__mobile-tabs').attr('id');
        $('#' + id).find('.profile__mobile-tabs-btn input').val(text);
    });

    /*==============================
    Modal
    ==============================*/
    $('.open-modal').magnificPopup({
        fixedContentPos: true,
        fixedBgPos: true,
        overflowY: 'auto',
        type: 'inline',
        preloader: false,
        focus: '#username',
        modal: false,
        removalDelay: 300,
        mainClass: 'my-mfp-zoom-in',
    });

    $('.modal__btn--dismiss').on('click', function(e) {
        e.preventDefault();
        $.magnificPopup.close();
    });

    /*==============================
    Select2
    ==============================*/
    $('#quality').select2({
        placeholder: "Choose quality",
        allowClear: true
    });

    $('#country').select2({
        placeholder: "Choose country / countries"
    });

    $('#genre').select2({
        placeholder: "Choose genre / genres"
    });

    $('#subscription, #rights').select2();

    /*==============================
    Upload cover
    ==============================*/
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function(e) {
                $('#form__img').attr('src', e.target.result);
            }

            reader.readAsDataURL(input.files[0]);
        }
    }

    $('#form__img-upload').on('change', function() {
        readURL(this);
    });

    /*==============================
    Upload video
    ==============================*/
    $('.form__video-upload').on('change', function() {
        var videoLabel = $(this).attr('data-name');

        if ($(this).val() != '') {
            $(videoLabel).text($(this)[0].files[0].name);
        } else {
            $(videoLabel).text('Upload video');
        }
    });

    /*==============================
    Upload gallery
    ==============================*/
    $('.form__gallery-upload').on('change', function() {
        var length = $(this).get(0).files.length;
        var galleryLabel = $(this).attr('data-name');

        if (length > 1) {
            $(galleryLabel).text(length + " files selected");
        } else {
            $(galleryLabel).text($(this)[0].files[0].name);
        }
    });

    /*==============================
    Scroll bar
    ==============================*/
    $('.sidebar__nav-wrap').mCustomScrollbar({
        axis: "y",
        scrollbarPosition: "outside",
        theme: "custom-bar"
    });

    $('.main__table-wrap').mCustomScrollbar({
        axis: "x",
        scrollbarPosition: "outside",
        theme: "custom-bar2",
        advanced: {
            autoExpandHorizontalScroll: true
        }
    });

    $('.dashbox__table-wrap').mCustomScrollbar({
        axis: "x",
        scrollbarPosition: "outside",
        theme: "custom-bar3",
        advanced: {
            autoExpandHorizontalScroll: 2
        }
    });

    /*==============================
    Bg
    ==============================*/
    $('.section--bg').each(function() {
        if ($(this).attr("data-bg")) {
            $(this).css({
                'background': 'url(' + $(this).data('bg') + ')',
                'background-position': 'center center',
                'background-repeat': 'no-repeat',
                'background-size': 'cover'
            });
        }
    });

});
/*==============================
update product detail
==============================*/
function updateDetail(id){
    var sl = document.getElementById("soluong").value;
    var tonkho = document.getElementById("tonkho").value;
    var d1 = document.getElementById("ngaysx").value;
    var d2 = document.getElementById("ngayhh").value;
    var ngsx = null;
    var nghh=null;

    if(d1!= null){
        var ngaysx = new Date(document.getElementById("ngaysx").value);
        ngsx = ngaysx.getFullYear()+"-"+(ngaysx.getMonth()+1)+"-"+ ngaysx.getDate();
    }
    if(d2!= null){
        var ngayhh = new Date( document.getElementById("ngayhh").value);
        nghh = ngayhh.getFullYear()+"-"+(ngayhh.getMonth()+1)+"-"+ ngayhh.getDate();
    }
    console.log(ngsx);
    console.log(nghh)
    location.href="Product/UpdateDetails?masp="+id+"&soluong="+sl+"&tonkho="+tonkho+"&ngaysx="+ ngsx.toString()+"&ngayhh="+nghh.toString();

}
function updateRole(id){
    var user = document.getElementById("username").value;
    var email = document.getElementById("email").value;
    var fisrt = document.getElementById("firstname").value;
    var last = document.getElementById("lastname").value;
    location.href="Product/EditUser?makh =" + id + "username=" + user + "&email=" + email + "&firstname=" + fisrt + "&lastname=" + last ;
}
