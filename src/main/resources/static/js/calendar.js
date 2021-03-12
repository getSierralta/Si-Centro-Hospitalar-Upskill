let nav = 0; // what month we're on

const calendar = document.getElementById('calendar');
const backDrop = document.getElementById('modalBackDrop');
const selectedDay = document.getElementById('selectedDay');
const weekdays = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
let lastDaySquare = null;
const dt = new Date();


function openModal(monthName, daySquare, month){
    if(lastDaySquare != null){
        lastDaySquare.classList.remove('today');
        lastDaySquare = null;
    }    
    lastDaySquare = daySquare;
    selectedDay.innerText = "";
    selectedDay.innerText = daySquare.innerText+ ", "+monthName;
    daySquare.classList.add('today');

    const url = window.location.href;
    const st = url.split("/");
    const especialidade = st[5];
    const day = daySquare.innerText;
    const dia = "2021-"+month.toString()+"-"+day.toString();
    const vagas = document.getElementById("vagas");
    vagas.innerHTML = "";
    fetch(`http://localhost:8080/utente/calendariogeralutente/${especialidade}/${dia}`)
    .then(response => response.json())
    .then(data =>         
            data.forEach(element => { 
                const sidebar__list = document.createElement('li'); 
                sidebar__list.classList.add('sidebar__list-item');

                const time = document.createElement('span'); 
                time.classList.add('list-item__time');
                time.innerText = element.time;

                const title = document.createElement('span'); 
                title.classList.add('list-item__title');
                title.innerText = element.doctor.name;

                const button = document.createElement('button'); 
                button.innerText = "Marcar Consulta";


                const icon = document.createElement('div'); 
                icon.classList.add('icon');
                icon.classList.add('consulta');

                button.appendChild(icon);
                
                button.addEventListener('click', () => {
                    marcarConsulta(element);
                });

                sidebar__list.appendChild(time);
                sidebar__list.appendChild(title);
                sidebar__list.appendChild(button);
                vagas.appendChild(sidebar__list);
            })
        );  
}

function marcarConsulta(vaga){
    const popUp = document.getElementById("popup");
    popUp.style.visibility = 'visible';
    popUp.style.opacity = '1';
    const popUpContent = document.getElementById("popup__content");
    popUpContent.style.opacity = '1';
    popUpContent.style.transform = 'translate(-50%,-50%) scale(1)';
    //color: var(--color-grey);
      //  position: absolute;
        //top: 2.5rem;
        //right: 2.5rem;
        //font-size: 3rem;
        //text-decoration: none;
        //display: inline-block;
        //transform: all .2s;
        //line-height: 1;
    console.log(vaga);
}

function load(){  
    

   if(nav !== 0){
       dt.setMonth(new Date().getMonth() + nav);
   }

   const day = dt.getDate();
   const month = dt.getMonth();
   const year = dt.getFullYear();

   const fisrtDayOfMonth = new Date(year, month, 1);
   //0 is the last day of the previous month
   const daysInMonth = new Date(year, month+1, 0).getDate();

   //figuring out the day of the week
    const dateString = fisrtDayOfMonth.toLocaleDateString('en-us', {
        weekday: 'long',
        year: 'numeric',
        month: 'numeric',
        day: 'numeric',
    });

    //calculate the day that are not from this month
    const paddingDays = weekdays.indexOf(dateString.split(', ')[0]);

    const monthName = dt.toLocaleDateString('en-us', {month: 'long'});
    document.getElementById('monthDisplay').innerText = `${monthName} ${year}`;

    //reset the calendar
    calendar.innerHTML = '';
    let week = new Array();
    for(let i = 1; i <= paddingDays + daysInMonth; i++){

        const daySquare = document.createElement('div');
        daySquare.classList.add('calendar__day');
        const dateSquare = document.createElement('span');
        dateSquare.classList.add('calendar__date');
        daySquare.appendChild(dateSquare);
        //const dayString = `${month + 1}/${i - paddingDays}/${year}`;
        if(i > paddingDays){
            dateSquare.innerText = i - paddingDays;
        }else{
            daySquare.classList.add('inactive');
        }
        if(i - paddingDays < day && nav === 0 || nav < 0){
            daySquare.classList.add('full');
        }else{
            daySquare.addEventListener('click', () => openModal(monthName, daySquare, month));
        }
        week.push(daySquare);
        if(i === paddingDays + daysInMonth){
            for(var j = week.length; j < 7; j++){
                const daySquare2 = document.createElement('div');
                daySquare2.classList.add('calendar__day');
                const dateSquare2 = document.createElement('span');
                dateSquare2.classList.add('calendar__date');
                daySquare2.appendChild(dateSquare2);
                daySquare2.classList.add('inactive');
                week.push(daySquare2);
            }
            newWeek(week);
            week = [];
        }
        if(i % 7 === 0){
            newWeek(week);
            week = [];
        }
    }
}

function newWeek(week){
    const week2 = document.createElement('div');
    week2.classList.add('calendar__week');
    for (var i = 0; i < week.length; i++){
        week2.appendChild(week[i]);
     }
    calendar.appendChild(week2);
}

function initButtons(){
    document.getElementById('nextButton').addEventListener('click', () => {
        nav++;
        load();
    });
    document.getElementById('backButton').addEventListener('click', () => {
        nav--;
        load();
    });
}

initButtons();
load();