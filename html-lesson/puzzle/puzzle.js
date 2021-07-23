var counter = new Array();
var imagesouce = new Array("1.gif","2.gif","3.gif","4.gif","5.gif","6.gif","7.gif","8.gif","9.gif","10.gif","11.gif","12.gif","13.gif","14.gif","15.gif","blink.gif");

function start() {
    for(a=0; a<16; a++) {
        counter[a] = Math.round(Math.random()*15);
        for(b=0; b<a; b++) {
            if(counter[a] == counter[b])
            a--
        }
    }
    mix();
} // start function end

function mix() {
    for(i=0; i<16; i++) {
        document.image[i].src = imagesouce[counter[i]];
        if(counter[i]==15)
            blink=i;
    }
} // mix function end
