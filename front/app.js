const months = {
  Январь: 31,
  Февраль: 28,
  Март: 31,
  Апрель: 30,
  Май: 31,
  Июнь: 30,
  Июль: 31,
  Август: 31,
  Сентябрь: 30,
  Октябрь: 31,
  Ноябрь: 30,
  Декабрь: 31,
};
let currentMonth = "Январь";
let selectedDay;

changeCalendarDays(months[currentMonth]);
getBookingsFromServer();

const bookBtn = document.getElementById("book");
bookBtn.addEventListener("click", (e) =>
  bookDayToServer(selectedDay.value, getCurrentMonthNumber())
);

document.getElementById("month").innerHTML = currentMonth;
document
  .getElementById("prev-month")
  .addEventListener("click", () => changeCalendarMonth(-1));
document
  .getElementById("next-month")
  .addEventListener("click", () => changeCalendarMonth(1));

function getBookingsFromServer() {
  let url = `http://localhost:8089/booking/month/${getCurrentMonthNumber()}`;
  fetch(url)
    .then((e) => e.json())
    .then((e) => showBookedDays(e));
}

function updateCountBookedDaysFromServer(month) {
    let url = `http://localhost:8089/booking/month/${month}/free`;
      fetch(url).then((e) => e.json())
        .then(e => updateFreeDays(e))
        .catch(() => updateFreeDays({'count': 'Ошибка на сервере'}));
}

function updateFreeDays(freeDaysObject) {
    document.getElementById("count-free-days").innerHTML = freeDaysObject.count;
}

function bookDayToServer(day, month) {
    let url = 'http://localhost:8089/booking';
    fetch(url, {
      method: "POST",
      headers: { "content-type": "application/json" },
      body: JSON.stringify({
        month: month,
        day: day,
      }),
    })
      .then((e) => selectedDay.classList.add("booked"))
      .then((e) => unSelectDay())
      .then((e) => updateCountBookedDaysFromServer(getCurrentMonthNumber()))
      .catch(() => console.log("Проблемы на сервере!"));
}

function showBookedDays(bookedDays) {
  bookedDays.forEach((bookedDay) => bookDay(bookedDay));
}



function bookDay(bookedDay) {
  Array.from(document.getElementsByClassName("day-item"))
    .filter((e) => Number(e.value) === bookedDay.dayNumber)
    .forEach((e) => e.classList.add("booked"));
}

function getCurrentMonthNumber() {
    return getCurrentMonthIndex() + 1;
}

function getCurrentMonthIndex() {
  return Object.keys(months).findIndex((e) => e === currentMonth);
}

function changeCalendarMonth(monthPlus) {
  let newMonthIndex =
    Object.keys(months).findIndex((e) => e === currentMonth) + monthPlus;
  if (newMonthIndex >= 0 && newMonthIndex < 12) {
    document.getElementById("month").innerHTML =
      Object.keys(months)[newMonthIndex];
    currentMonth = Object.keys(months)[newMonthIndex];
    changeCalendarDays(months[currentMonth]);    
    getBookingsFromServer(getCurrentMonthNumber());
  }
}

function changeCalendarDays(days) {
  document.getElementById("days").innerHTML = Array(days)
    .fill(1)
    .map((e, i) => createDay(e + i))
    .join("");
  Array.from(document.getElementsByClassName("day-item")).forEach((dayItem) =>
    dayItem.addEventListener("click", (e) => selectDayInCalendar(e))
  );
  updateCountBookedDaysFromServer(getCurrentMonthNumber());
}

function selectDayInCalendar(event) {
    console.log(event.target);
  if (selectedDay === undefined) {
    selectedDay = event.target;
    event.target.classList.add("active");
    bookBtn.classList.remove("d-none");
  } else if (selectedDay.value === event.target.value) {
    unSelectDay();
    selectedDay = undefined;
  } else {
    selectedDay.classList.remove('active');
    event.target.classList.add("active");
    selectedDay = event.target;
  }
}

function unSelectDay() {
    if (selectedDay !== undefined) {
        bookBtn.classList.add("d-none");
        selectedDay.classList.remove("active");
    }
    selectedDay = undefined;
}

function createDay(dayNumber) {
  return `<li class='day-item' value=${dayNumber}>${dayNumber}</li>`;
}
