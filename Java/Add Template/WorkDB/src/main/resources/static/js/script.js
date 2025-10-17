(function ($) {
        "use strict";

        $(document).ready(function() {

            initializeStickyNavbar();

            initializeMenuHandlers();

            initializeSmoothScroll();
        });

        function initializeStickyNavbar() {
            $(".navbar").sticky({
                topSpacing: 0,
                className: 'is-sticky',
                wrapperClassName: 'sticky-wrapper'
            });
        }

        function initializeMenuHandlers() {
            $('.navbar-collapse a').on('click', function() {
                $(".navbar-collapse").collapse('hide');
            });
        }

        function initializeSmoothScroll() {
            $('.smoothscroll').click(function(e) {
                e.preventDefault();

                var target = $(this).attr('href');
                var targetElement = $(target);
                var navHeight = $('.navbar').outerHeight();

                scrollToElement(targetElement, navHeight);
            });
        }

        function scrollToElement(element, navHeight) {
            var offset = element.offset().top - navHeight;

            $('html, body').animate({
                scrollTop: offset
            }, 600);
        }

        $(window).on('resize', function() {
            if ($('.navbar').hasClass('is-sticky')) {
                $('.navbar').sticky('update');
            }
        });

    })(jQuery);
