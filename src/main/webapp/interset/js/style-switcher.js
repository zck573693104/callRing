


(function ($) {
    "use strict";
    var mainSSwitcher = {

        s_fun: function () {

            /*=====================================
             THEME SWITCHER SCRIPTS 
            ===================================*/

            //THE CALLING OF PANEL ON CLICKING  BUTTON 

            jQuery('#switch-panel').click(function () {
                if (jQuery(this).hasClass('show-panel')) {
                    jQuery('.switcher').css({ 'left': '-95px' });
                    jQuery('#switch-panel').removeClass('show-panel');
                    jQuery('#switch-panel').addClass('hide-panel');
                } else if (jQuery(this).hasClass('hide-panel')) {
                    jQuery('.switcher').css({ 'left': 0 });
                    jQuery('#switch-panel').removeClass('hide-panel');
                    jQuery('#switch-panel').addClass('show-panel');
                }
            });

           
            $('#blue').click(function () {
                $('#mainCSS').attr('href', '../interset/css/themes/blue.css');
            }); 
           
            $('#red').click(function () {
                $('#mainCSS').attr('href', '../interset/css/themes/red.css');
            });
                  

        },

        initialization: function () {
            mainSSwitcher.s_fun();

        }

    }
    // Initializing ///

    $(document).ready(function () {
        mainSSwitcher.s_fun();
    });

}(jQuery));
