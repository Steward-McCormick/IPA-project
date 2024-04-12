const current_html_height = document.querySelector("#html").offsetHeight;

function get_history_field_height() {
    const field = document.getElementsByClassName("history-field")[0];
    return field.offsetHeight;
}

window.addEventListener('load', () => {
    const window_height = window.innerHeight;
    console.log(window_height)
    if (window_height >= get_history_field_height()){
        document.querySelector("#html").style.height = "100%";
        return;
    }

    const field = document.getElementsByClassName("history-field")[0];
    console.log(get_history_field_height())
    document.querySelector("#html").style.height = get_history_field_height() + 40 + 65 + 48 + 16 + "px";
})
