function setcheckboxes() {
	//When checkboxes/radios checked/unchecked, toggle background color
	$('.form-group').on('click','input[type=radio]',function() {
		//alert('remove class');
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
	      $(this).closest('.additional-checked-info-wrap').find('.additional-checked-info').removeClass('hide').find('input,select');
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
	  if($(this).is(':checked')) {
		  $(this).closest('.radio-inline, .radio').addClass('checked');
		  $(this).closest('.radio-inline, .radio').siblings().removeClass('checked');
	  }

	});
}

function setcheckboxstate() {

	//Show additional info text box when relevant checkbox checked
	$('.additional-info-wrap input[type=checkbox]').each(function() {
	  if($(this).is(':checked')) {
		  $(this).closest('.checkbox-inline, .checkbox').addClass('checked');
	      $(this).closest('.additional-info-wrap').find('.additional-info').removeClass('hide').find('input,select').removeAttr('disabled');
	  }
	  else {
	      $(this).closest('.additional-info-wrap').find('.additional-info').addClass('hide').find('input,select').val('').attr('disabled','disabled');
	  }
	});
	
	$('.additional-checked-info-wrap input[type=checkbox]').each(function() {
		  if($(this).is(':checked')) {
			  $(this).closest('.checkbox-inline, .checkbox').addClass('checked');
		      $(this).closest('.additional-checked-info-wrap').find('.additional-checked-info').removeClass('hide').find('input,select').removeAttr('disabled');
		  }
		  else {
		  	if(!$(this).hasClass('yes-no')) {
		      $(this).closest('.additional-checked-info-wrap').find('.additional-checked-info').addClass('hide').find('input[type=checkbox]').attr('checked',false).attr('disabled','disabled');
		  	}
		  }
	});

/*	var loop = 0;
	$('.checkbox-inline .yes-no').each(function(){
		if (++loop < 3) {
			$.each(this.attributes, function(){
				if(this.specified) {
					alert(this.name + ":" + this.value);
				}
			});
		}
	});
*/	
	$('input[type=radio]').each(function() {
		  if($(this).is(':checked')) {
			  //alert('checked');
			  $(this).closest('.radio-inline, .radio').addClass('checked');
		  } else {
			  $(this).closest('.radio-inline, .radio').removeClass('checked');
		  }
	});
	
	$('input[type=checkbox]').each(function() {
			if ($(this).is(':checked')) {
				  $(this).closest('.checkbox-inline, .checkbox').addClass('checked');
			} else {
				  $(this).closest('.checkbox-inline, .checkbox').removeClass('checked');
			}
		});

}

function setcurrenttime(dateObj, timeObj) {
	var now = new Date();

	var day = now.getDate();
	var month = now.getMonth() + 1;
	var year = now.getFullYear();
	var hour   = now.getHours();
	var minute = now.getMinutes();
	var ampm = " am";

	if (month < 10) month = "0" + month;
	if (day < 10) day = "0" + day;
    if (hour >= 12) ampm = " pm";  
	if (hour > 12) hour = hour - 12;
	if (hour   < 10) { hour   = "0" + hour;   }
    if (minute < 10) { minute = "0" + minute; }
	
    var todayDt = month + "/" + day + "/" + year;
    var todayTime = hour + ":" + minute + ampm;
    $('#'+dateObj).val(todayDt);
    $('#'+timeObj).val(todayTime);   
}

function setupStartEndDates(startId, endId) {
	$('#'+startId).datetimepicker({
		  format:'m/d/Y',
		  formatDate: 'm/d/Y',
		  onShow:function( ct ){
		   this.setOptions({
		    maxDate:$('#'+endId).val()?$('#'+endId).val():false
		   })
		  },
		  timepicker:false
		 });
		 $('#'+endId).datetimepicker({
		  format:'m/d/Y',
		  formatDate: 'm/d/Y',
		  onShow:function( ct ){
		   this.setOptions({
		    minDate:$('#'+startId).val()?$('#'+startId).val():false
		   })
		  },
		  timepicker:false
	 });	
}

function setupDateTimeObjects() {
    $('.date').datetimepicker({
        timepicker:false,
        scrollInput:false,
        format:'m/d/Y',
        formatDate:'m/d/Y'
      });

    $('.date').mask('00/00/0000');
	$('.time').mask('Hh:Ii am', {'translation':{
		  H : {pattern: /[0-1]/},
		  h : {pattern: /[0-9]/},
		  I : {pattern: /[0-5]/},
		  i : {pattern: /[0-9]/},
		  a : {pattern: /[A|a|P|p]/},
		  m : {pattern: /[M|m]/}
	  	}
	});
	  
    $('.date').attr('autocomplete', 'off');
    $('.time').attr('autocomplete', 'off');

}