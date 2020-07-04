/*
	Custom checkbox and radio button - Jun 18, 2013
	(c) 2013 @ElmahdiMahmoud 
	license: http://www.opensource.org/licenses/mit-license.php
*/
$(document).ready(function () {
    $.fn.toggleCheckbox = function () {
        this.attr('checked', !this.attr('checked'));
    }
    $('input[type="radio"]').each(function (index, element) {
        if (element.checked == true) {
            $(element).wrap('<div class="radio-btn checkedRadio"><i></i></div>');
        } else {
            $(element).wrap('<div class="radio-btn"><i></i></div>');
        }
    })
    $('.radio-btn').on('click', function () {
        var _this = $(this),
            block = _this.parent().parent();
            checkName = _this.children().children().attr("name");
        block.find('input:radio[name=' + checkName + ']').attr('checked', false);

        block.find(".radio-btn").children().children().each(function (index, element) {
            if (element.name == checkName) {
                $(element).parent().parent().removeClass('checkedRadio');
            }
        });
        _this.addClass('checkedRadio');
        _this.find('input:radio').attr('checked', "checked");
        _this.find('input:radio')[0].checked = true;
        _this.find('input:radio').trigger("change");
    });

    $('input[type="checkbox"]').each(function (index, element) {
        if (element.checked == true) {
            if (element.disabled == true) {
                $(element).wrap('<div class="check-box checkedBoxDisable"><i></i></div>');
            } else {
                $(element).wrap('<div class="check-box checkedBox"><i></i></div>');
            }
        } else {
            if (element.disabled == true) {
                $(element).wrap('<div class="check-box checkedBoxUnDisable"><i></i></div>');
            } else {
                $(element).wrap('<div class="check-box"><i></i></div>');
            }
        }    
    });

    $('.check-box').on('click', function () {
        if ($(this).children().children()[0].disabled == false) {
            $(this).find(':checkbox').toggleCheckbox();
            $(this).toggleClass('checkedBox');
            if ($(this).hasClass("checkedBox") == true) {
                $(this).children().children()[0].checked = true;
            } else {
                $(this).children().children()[0].checked = false; 
            }
            $(this).children().children().trigger("change");
        }
    });
});
