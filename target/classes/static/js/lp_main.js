var viewportHeight = $(window).height();

// Total height the page has been scrolled so far
var getYOffset = function(){
  return $(window).scrollTop();
}

// Offset of an element with relative 
// to the document
// A wrapper over jQuery's offset() method
// to make the code readable
var getOffsetFromDocument = function(el) {
  return $(el).offset().top;
}

var flyOnScroll = function(percentOfEl){
  self = flyOnScroll;
  self.percentOfEl = percentOfEl;
  self.init();
  $(document).on('scroll', function(){          
        self.iterate();       
  });
};


flyOnScroll.init = function(){
  this.hideElNotInView();
};

flyOnScroll.isElementInView = function(el, percentInView){
  // elTopOffset -> vertical seperation of the element's top corner from 
  // documents top corner
  var elTopOffset = getOffsetFromDocument(el);   
  var elHeight = $(el).height(); // height of the element
  var elBottomOffset = elTopOffset + elHeight; 
  var vScrolled = getYOffset(); // height scrolled till now
  // docViewed -> total height of scrolled document till the
  // end of the current view
  var docViewed = viewportHeight + vScrolled;  
  
  percentInView = percentInView || 0;
  
  // Return false when the element is beneath the present view
  // or above the present view
  
  if ( ((elTopOffset + (percentInView/100) * elHeight) <= docViewed) 
      && ( docViewed <= (elTopOffset + elHeight + viewportHeight))) {
        console.log((elTopOffset + (percentInView/100) * elHeight), docViewed);
        return true;
  }
}

flyOnScroll.hideElNotInView = function(){
  var self = this;
  $('.a-section-container').each(function(index, el){    
    if (!self.isElementInView(el, self.percentOfEl)) {
      $(el).removeClass('animate');
      $(el).addClass('init');      
    }
  });
};

flyOnScroll.animateElInView = function(){
    var self = this;
    $('.a-section-container').each(function(index, el){
    if (self.isElementInView(el, 10)) {
      $(el).removeClass('init');
      $(el).addClass('animate');
    }
  });
};

flyOnScroll.iterate = function() {
   this.hideElNotInView();
   this.animateElInView();
};

flyOnScroll(7);

/*!
 * classie - class helper functions
 * from bonzo https://github.com/ded/bonzo
 * 
 * classie.has( elem, 'my-class' ) -> true/false
 * classie.add( elem, 'my-new-class' )
 * classie.remove( elem, 'my-unwanted-class' )
 * classie.toggle( elem, 'my-class' )
 */

/*jshint browser: true, strict: true, undef: true */
/*global define: false */

( function( window ) {

'use strict';

// class helper functions from bonzo https://github.com/ded/bonzo

function classReg( className ) {
  return new RegExp("(^|\\s+)" + className + "(\\s+|$)");
}

// classList support for class management
// altho to be fair, the api sucks because it won't accept multiple classes at once
var hasClass, addClass, removeClass;

if ( 'classList' in document.documentElement ) {
  hasClass = function( elem, c ) {
    return elem.classList.contains( c );
  };
  addClass = function( elem, c ) {
    elem.classList.add( c );
  };
  removeClass = function( elem, c ) {
    elem.classList.remove( c );
  };
}
else {
  hasClass = function( elem, c ) {
    return classReg( c ).test( elem.className );
  };
  addClass = function( elem, c ) {
    if ( !hasClass( elem, c ) ) {
      elem.className = elem.className + ' ' + c;
    }
  };
  removeClass = function( elem, c ) {
    elem.className = elem.className.replace( classReg( c ), ' ' );
  };
}

function toggleClass( elem, c ) {
  var fn = hasClass( elem, c ) ? removeClass : addClass;
  fn( elem, c );
}

var classie = {
  // full names
  hasClass: hasClass,
  addClass: addClass,
  removeClass: removeClass,
  toggleClass: toggleClass,
  // short names
  has: hasClass,
  add: addClass,
  remove: removeClass,
  toggle: toggleClass
};

// transport
if ( typeof define === 'function' && define.amd ) {
  // AMD
  define( classie );
} else {
  // browser global
  window.classie = classie;
}

})( window );
/**
 * cbpSplitLayout.js v1.0.0
 * http://www.codrops.com
 *
 * Licensed under the MIT license.
 * https://www.opensource.org/licenses/mit-license.php
 * 
 * Copyright 2013, Codrops
 * http://www.codrops.com
 */
(function() {

	'use strict';

	// http://stackoverflow.com/a/11381730/989439
	function mobilecheck() {
		var check = false;
		(function(a){if(/(android|ipad|playbook|silk|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(a)||/1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(a.substr(0,4)))check = true})(navigator.userAgent||navigator.vendor||window.opera);
		return check;
	}

	var splitlayout = document.getElementById( 'splitlayout' ),
		leftSide = splitlayout.querySelector( 'div.intro > div.side-left' ),
		rightSide = splitlayout.querySelector( 'div.intro > div.side-right' ),
     centerlogo = splitlayout.querySelector( 'div.intro > div.logo' ),
		pageLeft = splitlayout.querySelector( 'div.page-left' ),
		pageRight = splitlayout.querySelector( 'div.page-right' ),
     
      
		eventtype = mobilecheck() ? 'touchstart' : 'click',
		transEndEventNames = {
			'WebkitTransition': 'webkitTransitionEnd',
			'MozTransition': 'transitionend',
			'OTransition': 'oTransitionEnd',
			'msTransition': 'MSTransitionEnd',
			'transition': 'transitionend'
		},
		transEndEventName = transEndEventNames[Modernizr.prefixed( 'transition' )];

	function init() {
		if( mobilecheck() ) {
			classie.add( splitlayout, 'mobile-layout' );
		}
		classie.add( splitlayout, 'reset-layout' );

		leftSide.querySelector( 'div.intro-content').addEventListener( eventtype, function( ev ) {
			reset();
			classie.add( splitlayout, 'open-left' );
		} );

		rightSide.querySelector( 'div.intro-content' ).addEventListener( eventtype, function( ev ) {
			reset();
			classie.add( splitlayout, 'open-right' );
		} );
    
    
    

		// back to intro
		// after transition ends:
		var onEndTransFn = function() { 
				this.removeEventListener( transEndEventName, onEndTransFn );
				classie.add( splitlayout, 'reset-layout' );
				document.body.scrollTop = document.documentElement.scrollTop = 0;
			},
			backToIntro = function( ev ) {
				ev.preventDefault();
				ev.stopPropagation();
				var dir = classie.has( ev.target, 'back-right' ) ? 'left' : 'right',
					page = dir === 'right' ? pageRight : pageLeft;
				classie.remove( splitlayout, 'open-' + dir );
				classie.add( splitlayout, 'close-' + dir );
				page.addEventListener( transEndEventName, onEndTransFn );
			};

		splitlayout.querySelector( 'a.back-left' ).addEventListener( eventtype, backToIntro );
		splitlayout.querySelector( 'a.back-right' ).addEventListener( eventtype, backToIntro );
	}

	function reset() {
		classie.remove( splitlayout, 'close-right' );
		classie.remove( splitlayout, 'close-left' );
		classie.remove( splitlayout, 'reset-layout' );
	}

	init();

})();
var viewportHeight = $(window).height();

// Total height the page has been scrolled so far
var getYOffset = function(){
  return $(window).scrollTop();
}

// Offset of an element with relative 
// to the document
// A wrapper over jQuery's offset() method
// to make the code readable
var getOffsetFromDocument = function(el) {
  return $(el).offset().top;
}

var flyOnScroll = function(percentOfEl){
  self = flyOnScroll;
  self.percentOfEl = percentOfEl;
  self.init();
  $(document).on('scroll', function(){          
        self.iterate();       
  });
};


flyOnScroll.init = function(){
  this.hideElNotInView();
};

flyOnScroll.isElementInView = function(el, percentInView){
  // elTopOffset -> vertical seperation of the element's top corner from 
  // documents top corner
  var elTopOffset = getOffsetFromDocument(el);   
  var elHeight = $(el).height(); // height of the element
  var elBottomOffset = elTopOffset + elHeight; 
  var vScrolled = getYOffset(); // height scrolled till now
  // docViewed -> total height of scrolled document till the
  // end of the current view
  var docViewed = viewportHeight + vScrolled;  
  
  percentInView = percentInView || 0;
  
  // Return false when the element is beneath the present view
  // or above the present view
  
  if ( ((elTopOffset + (percentInView/100) * elHeight) <= docViewed) 
      && ( docViewed <= (elTopOffset + elHeight + viewportHeight))) {
        console.log((elTopOffset + (percentInView/100) * elHeight), docViewed);
        return true;
  }
}

flyOnScroll.hideElNotInView = function(){
  var self = this;
  $('.a-section-container').each(function(index, el){    
    if (!self.isElementInView(el, self.percentOfEl)) {
      $(el).removeClass('animate');
      $(el).addClass('init');      
    }
  });
};

flyOnScroll.animateElInView = function(){
    var self = this;
    $('.a-section-container').each(function(index, el){
    if (self.isElementInView(el, 10)) {
      $(el).removeClass('init');
      $(el).addClass('animate');
    }
  });
};

flyOnScroll.iterate = function() {
   this.hideElNotInView();
   this.animateElInView();
};

flyOnScroll(10);