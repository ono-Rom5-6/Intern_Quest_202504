/**
 * 
 */
'use strict';

jQuery(function($) {
	$(function() {
		$('#early').on('change', function() {
			// 既存の選択肢をクリア
			//citySelect.innerHTML = "";

			$('[name=subPattern]').val('');
			if ($(this).is(':checked')) {
				$('.D').css('display', 'inline');
				$('.E').css('display', 'inline');
				$('.F').css('display', 'inline');
				$('.G').css('display', 'none');
				//$('.mail').css('display','inline');
				//$("#rtime").val("24時間");
			}
		});
		$('#normal').on('change', function() {
			$('[name=subPattern]').val('');
			if ($(this).is(':checked')) {
				$('.D').css('display', 'none');
				$('.E').css('display', 'none');
				$('.F').css('display', 'none');
				$('.G').css('display', 'none');

				// $('.tel').css('display','inline');
				//$("#rtime").val("");
			}
		});
		$('#late').on('change', function() {
			$('[name=subPattern]').val('');
			if ($(this).is(':checked')) {
				$('.D').css('display', 'inline');
				$('.E').css('display', 'inline');
				$('.F').css('display', 'inline');
				$('.G').css('display', 'inline');
				//$('.mail').css('display','none');
				//$('.tel').css('display','inline');
				//$("#rtime").val("");
			}
		});
	});


});

