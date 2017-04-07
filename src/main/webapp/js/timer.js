/* Its doesn`t work yet*/

function getTimeRemaining(endtime){
    var t = Date.parse(endtime) - Date.parse(new Date());
    var seconds = Math.floor( (t/1000) % 60 );
    var minutes = Math.floor( (t/1000/60) % 60 );
    var hours = Math.floor( (t/(1000*60*60)) % 24 );
    var days = Math.floor( t/(1000*60*60*24) );
    return {
        'total': t,
        'days': days,
        'hours': hours,
        'minutes': minutes,
        'seconds': seconds
    };
}

initializeClock('clockdiv', deadline);

function initializeClock(id, endtime){
    var clock = document.getElementById(id);
    var daysSpan = clock.querySelector('.days');
    var hoursSpan = clock.querySelector('.hours');
    var minutesSpan = clock.querySelector('.minutes');
    var secondsSpan = clock.querySelector('.seconds');
    function updateClock(){
        var t = getTimeRemaining(endtime);

        daysSpan.innerHTML = ( '0' + t.days).slice(-2);
        hoursSpan.innerHTML = ( '0' + t.hours).slice(-2);
        minutesSpan.innerHTML = ('0' + t.minutes).slice(-2);
        secondsSpan.innerHTML = ('0' + t.seconds).slice(-2);
        if(t.total<=0){
            clearInterval(timeinterval);
        }
    }

    updateClock(); // запустите функцию один раз, чтобы избежать задержки
    var timeinterval = setInterval(updateClock,1000);
}