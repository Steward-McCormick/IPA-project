function addToCalcList() {
    const form = document.getElementById("form");
    const div = document.createElement('div');
    div.innerHTML = 
    `
		<select id="consumers" class="form-field" form="form">
			<option style="display: none;" value="">Потребитель</option>
			<option value="Установки">Установки</option>
		    <option value="Автомобильный транспорт">Автомобильный транспорт</option>
		</select>
		<select id="fuel-type" class="form-field" form="form">
		    <option style="display: none;" value="">Топливо</option>
			<option value="Сырая нефть">Сырая нефть</option>
			<option value="Газовый конденсат">Газовый конденсат</option>
			<option value="Бензин автомобильный">Бензин автомобильный</option>
			<option value="Дизельное топливо">Дизельное топливо</option>
			<option value="Керосин осветительный">Керосин осветительный</option>
			<option value="Топливо нефтяное(мазут)">Топливо нефтяное(мазут)</option>
			<option value="Пропан и бутан сж.">Пропан и бутан сж.</option>
			<option value="Углеводородные газы сж.">Углеводородные газы сж.</option>
			<option value="Битум">Битум</option>
			<option value="Коксующийся уголь">Коксующийся уголь</option>
			<option value="Уголь каменный">Уголь каменный</option>
			<option value="Природный газ">Природный газ</option>
			<option value="Дрова для отопления">Дрова для отопления</option>
		</select>
				
		<input type="text" placeholder="Количество" class="form-field" form="form">
				
		<select id="unit" class="form-field" form="form">
			<option style="display: none;" value="">Единицы измерения</option>
			<option value="Тонны/год">Тонны</option>
			<option value="м3/год">Метры кубические</option>
		</select>
				
		<a href="#" onclick="delete_calculation(this)"><img src="img/cross.svg" class="form-cross"></a>
    `
    if(document.getElementsByClassName('calculation-form-fields').length >= 1) {
        div.style.marginTop = "16px";
    }
    div.className = "calculation-form-fields";

    form.appendChild(div);

    let h = document.querySelector('#html').offsetHeight + 75;
    document.getElementById('html').style.height = h + "px";

    return false;
}

const current_html_height = document.querySelector("#html").offsetHeight;

function delete_calculation(el) {
    el.parentNode.remove();

    let h;

    const sidebar_h = document.getElementById('left-sidebar').offsetHeight;
    if(document.querySelector("#html").offsetHeight - 75 >= sidebar_h) {
        h = document.querySelector("#html").offsetHeight - 75;
    }
    else {
        h = document.querySelector("#html").offsetHeight;
    }
    document.getElementById('html').style.height = h + "px";

    edit_top_form();
}

function edit_top_form() {
    const div = document.getElementsByClassName("calculation-form-fields");
    div[0].style.marginTop = 0;
}

function calculation_complete_informing() {
    const page = document.getElementsByClassName("calculation-area")[0]
    
}