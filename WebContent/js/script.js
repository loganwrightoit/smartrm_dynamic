$(document).ready(function(){
	
    // this handles the default page loaded at start
    $(".content").load("views/welcome.jsp");
    
        // display home.html when home button clicked
	$("#home").click(function(){
		$(".content").load("views/welcome.jsp");
        console.log("home clicked");
	});
        // display resource.html when resource button clicked
	$("#resource").click(function(){
		$(".content").load("views/resource.jsp");
		console.log("resource clicked");
	});
	// display location.html when resource button clicked
	$("#location").click(function(){
		$(".content").load("views/location.jsp");
		console.log("location clicked");
	});
        // display booking html when booking button clicked
	$("#booking").click(function(){
		$(".content").load("Booking",function()
			{
			// new bookings
	         $("#form1").submit(function(event)
	         {
	        	$.ajax({
	        	    type: $("#form1").attr("method"),
	        	    url:  $("#form1").attr("action"),
	        	    data: $("#form1").serialize(),
	        	    success: function(data) {
	        	    	if(data != "false")
	        	    	{
	        	    		$(".content").html(data);
	        	    	}
	        	    	else
	        	    	{
		        	    	alert("error");	
	        	    	}
	        	    }
	        	  });
	        	event.preventDefault();
	         });
			});
	});
	
	$("#home").click(function()
	{
		$("#location,#resource,#booking").removeClass("active");
		$(this).addClass("active");
	});
	$("#location").click(function()
	{
		$("#home,#resource,#booking").removeClass("active");
		$(this).addClass("active");
	});
	$("#resource").click(function()
	{
		$("#home,#location,#booking").removeClass("active");
		$(this).addClass("active");
	});
	$("#booking").click(function()
	{
		$("#home,#resource,#location").removeClass("active");
		$(this).addClass("active");
	});
         
         // new resource
         $(document).on('click','#newresource',function(event)
         {
            if($("#rresource").val() == "ch")
            {
                $(".content").load("addnewconferencehall.html");
                console.log("test");
            }
            if($("#rresource").val() == "esc")
            {
                $(".content").load("esc_register.html");
            }
            if($("#rresource").val() == "mr")
            {
                $(".content").load("registermeetingroom.html");
            }            
         })

         $(document).on('click','#updateresource',function(event)
         {
            if($("#rresource").val() == "ch")
            {
                $(".content").load("updateconferencehall.html");
                console.log("test");
            }
            if($("#rresource").val() == "esc")
            {
                $(".content").load("esc_update.html");
            }
            if($("#rresource").val() == "mr")
            {
                $(".content").load("updatemeetingroom.html");
            }
         })
         
         $(document).on('click','#deleteresource',function(event)
         {
            if($("#rresource").val() == "ch")
            {
                $(".content").load("removeconferencehall.html");
                console.log("test");
            }
            if($("#rresource").val() == "esc")
            {
                $(".content").load("esc_delete.html");
            }
            if($("#rresource").val() == "mr")
            {
                $(".content").load("deletemeetingroom.html");
            }
         })
         
         // Location actions
         
         $(document).on('click','#newlocation',function(event)
         {
            $(".content").load("/WEB-INF/views/location_add.jsp");         
         })

         $(document).on('click','#updatelocation',function(event)
         {
            $(".content").load("/WEB-INF/views/location_update.jsp");
         })
         
         $(document).on('click','#deletelocation',function(event)
         {
<<<<<<< HEAD
            $(".content").load("/WEB-INF/views/location_delete.jsp");
         })
=======
            $(".content").load("views/location_delete.jsp");
         });
         
         
>>>>>>> 398448d72a0b1984053debc2abba6224090d1a61

	
});