
var AlternateProgressBar = require('it.smc.alternativeprogressbar');

var window = Ti.UI.createWindow({
	title: 'SMC Progress Bar',
	backgroundColor: '#333'
});

var label = Ti.UI.createLabel({
	width: '80%',
	html: [
		'Touch around to see the values applied to the progress bar at the top.',
		'',
		'<b>Indeterminate</b> mode will be disabled while you touch.',
		'',
		'Slide <b>horizontally</b> to set the <b>value</b>,',
		'slide <b>vertically</b> to set the <b>secondary</b> value.'
	].join('<br />')
});

var bar = AlternateProgressBar.createProgressBar({
	min: 0,
	max: 100,
	value: 33,
	top: '-26dip', // Magical number to make the Progress Bar stick to the Action Bar
	width: '100%',
	indeterminate: true,
	touchEnabled: false
});

window.add(bar);
window.add(label);

window.open();

window.addEventListener('touchstart', start);
window.addEventListener('touchend', cancel);
window.addEventListener('touchcancel', cancel);
window.addEventListener('touchmove', move);

function start(event) {
	move(event);
	bar.indeterminate = false;
}

function cancel(event) {
	move(event);
	bar.indeterminate = true;
}

var caps = Ti.Platform.displayCaps;

function move(event) {
	bar.value = (100 * event.x) / caps.platformWidth;
	bar.secondary = (100 * event.y) / caps.platformHeight;
}
