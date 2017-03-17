$(document).ready(function(){

    $('#email').keyup(function(){
        var email = $(this).val();
        var Result = $('#result'); // Get ID of the result DIV where we display the results
        if(email.length > 2) { // if greater than 2 (minimum 3)
            Result.html('Loading...'); // you can use loading animation here
            var dataPass = '&email='+email;
            $.ajax({ // Send the username val to available.php
                type : 'POST',
                data : dataPass,
                url  : 'checkEmail',
                success: function(responseText){ // Get the result
                    if(responseText == 0){
                        Result.html('<span class="success">Available</span>');
                    }
                    else if(responseText > 0){
                        Result.html('<span class="error">Email already registered !!</span>');
                    }
                    else{
                        alert('Problem with sql query');
                    }
                }
            });
        }else{
            Result.html('Not valid !!');
        }
        if(email.length == 0) {
            Result.html('');
        }
    });
});