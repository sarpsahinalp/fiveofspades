export function timeFormat(d:Date) {
    let hours = d.getHours();
    let minutes = format_two_digits(d.getMinutes());
    return hours + ":" + minutes;
}

export function dateFormat(d:Date) {
    let date = d.getDate();
    let month = d.getMonth();
    let year = d.getFullYear();
    return date + "." + month + "." + year;
}

function format_two_digits(n:number) {
    return n < 10 ? '0' + n : n;
}