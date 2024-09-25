$(document).ready(function(){
    $("h5").on("click", function(){
        $(this).closest('section').find("p").slideToggle("4s");
    });

});