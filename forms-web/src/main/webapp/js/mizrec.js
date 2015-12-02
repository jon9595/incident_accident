function setcheckboxes() {
	//When checkboxes/radios checked/unchecked, toggle background color
	$('.form-group').on('click','input[type=radio]',function() {
	  $(this).closest('.form-group').find('.radio-inline, .radio').removeClass('checked');
	  $(this).closest('.radio-inline, .radio').addClass('checked');
	});
	$('.form-group').on('click','input[type=checkbox]',function() {
	  $(this).closest('.checkbox-inline, .checkbox').toggleClass('checked');
	});

	//Show additional info text box when relevant checkbox checked
	$('.additional-info-wrap input[type=checkbox]').click(function() {
	  if($(this).is(':checked')) {
	      $(this).closest('.additional-info-wrap').find('.additional-info').removeClass('hide').find('input,select').removeAttr('disabled');
	  }
	  else {
	      $(this).closest('.additional-info-wrap').find('.additional-info').addClass('hide').find('input,select').val('').attr('disabled','disabled');
	  }
	});

	$('.additional-checked-info-wrap input[type=checkbox]').click(function() {
	  if($(this).is(':checked')) {
	      $(this).closest('.additional-checked-info-wrap').find('.additional-checked-info').removeClass('hide').find('input,select').removeAttr('disabled');
	  }
	  else {
	  	if(!$(this).hasClass('yes-no')) {
	      $(this).closest('.additional-checked-info-wrap').find('.additional-checked-info').addClass('hide').find('input[type=checkbox]').attr('checked',false).attr('disabled','disabled');
	  	}
	  }
	});


	//Show additional info text box when relevant radio checked
	$('input[type=radio]').click(function() {
	  $(this).closest('.form-group').find('.additional-info-wrap .additional-info').addClass('hide').find('input,select').val('').attr('disabled','disabled');
	  if($(this).closest('.additional-info-wrap').length > 0) {
	      $(this).closest('.additional-info-wrap').find('.additional-info').removeClass('hide').find('input,select').removeAttr('disabled');
	  }        
	});
}

function setcheckboxstate() {
	//Show additional info text box when relevant checkbox checked
	$('.additional-info-wrap input[type=checkbox]').each(function() {
	  if($(this).is(':checked')) {
		  $(this).closest('.checkbox-inline, .checkbox').toggleClass('checked');
	      $(this).closest('.additional-info-wrap').find('.additional-info').removeClass('hide').find('input,select').removeAttr('disabled');
	  }
	  else {
	      $(this).closest('.additional-info-wrap').find('.additional-info').addClass('hide').find('input,select').val('').attr('disabled','disabled');
	  }
	});
}