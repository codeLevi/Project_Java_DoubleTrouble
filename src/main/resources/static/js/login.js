$(document).ready(function () {

    let pathName = window.location.pathname;
    let loginFormLink = $('#login-form-link');
    let registerFormLink = $('#register-form-link');

    if (pathName === '/register') {
        $("#register-form").delay(100).fadeIn(100);
        $("#login-form").fadeOut(100);
        loginFormLink.removeClass('active');
        registerFormLink.addClass('active');
    }

    loginFormLink.click(function (e) {
        $("#login-form").delay(100).fadeIn(100);
        $("#register-form").fadeOut(100);
        registerFormLink.removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    registerFormLink.click(function (e) {
        $("#register-form").delay(100).fadeIn(100);
        $("#login-form").fadeOut(100);
        loginFormLink.removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
});
