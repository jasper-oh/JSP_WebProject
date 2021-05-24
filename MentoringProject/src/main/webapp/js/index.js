/**
 * 
 */
$("#article1 .slide_group").slick({
    autoplay: true, // 자동재생
    autoplaySpeed: 5000, // 간격시간
    dots: false, // 동그라미버튼
    speed: 600, // 바뀌는시간(생략가능)
    slidesToShow: 1, // 보여질슬라이드수(생략가능)
    slidesToScroll: 1, // 이동슬라이드수(생략가능)
    pauseOnHover: false, // 마우스오버시 멈춤여부(생략가능)
    pauseOnDotsHover: false, // 동그라미번호버튼에 호버시 멈춤여부(생략가능)
    pauseOnFocus: false, // 동그라미번호버튼 클릭시 자동실행 멈춤여부
    cssEase: 'linear', // 속도함수(생략가능)
    draggable: true, // 마우스드래그시 슬라이드 교체가능여부(생략가능)
    fade: true,
    arrows: false, // 좌우화살표 사용여부(생략가능)
})

// nav고정
$(window).on('scroll', function () {
    var sct = $(this).scrollTop()
    if (sct >= 1 && !$('#header').hasClass('on')) {
        $('#header').addClass('on')
    } else if (sct < 1 && $('#header').hasClass('on')) {
        $('#header').removeClass('on')
    }
})


//nav 버튼 클릭시 부드럽게 스크롤
$('.gotop').on('click', function(e){
    e.preventDefault()
    $('html').animate({scrollTop: 0}, 500)
})