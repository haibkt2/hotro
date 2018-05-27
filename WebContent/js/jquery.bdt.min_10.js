/**
 * @license MIT
 * @license http://opensource.org/licenses/MIT Massachusetts Institute of Technology
 * @copyright 2014 Patric Gutersohn
 * @author Patric Gutersohn
 * @example index.html BDT in action.
 * @link http://bdt.gutersohn.de Documentation
 * @version 1.0.0
 *
 * @summary BDT - Bootstrap Data Tables
 * @description sorting, paginating and search for bootstrap tables
 */
!function(a){"use strict";var e=1,t=0,n=0,s="",d=null,r=!1,i="",l="",o="",p="",c="";a.fn.bdt=function(h,f){function u(e){var t=e,n=0;e.find("thead th").wrapInner('<span class="sort-element"/>').append(a("<span/>").addClass("sort-icon fa")).each(function(){var s=a(this),d=s.index(),r=!1,o=!0;s.click(function(){a(this).hasClass("disable-sorting")||(a(this).find(".sort-icon").hasClass(l)?a(this).find(".sort-icon").removeClass(l).addClass(i):a(this).find(".sort-icon").removeClass(i).addClass(l),n!=d&&(e.find(".sort-icon").removeClass(l),e.find(".sort-icon").removeClass(i),a(this).find(".sort-icon").toggleClass(l,o)),t.find("td").filter(function(){return a(this).index()===d}).sortElements(function(e,t){return a.text([e])>a.text([t])?r?-1:1:r?1:-1},function(){return this.parentNode}),r=!r,n=d)})})}function v(){a("#table-nav").remove(),s=a("<ul/>"),a.each(new Array(t),function(e){var t="";a();e+1==1&&(t="active"),s.append(a("<li/>").addClass(t).data("page",e+1).append(a("<a/>").text(e+1)))}),a("#table-footer").addClass("row").append(a("<nav/>").addClass("pull-right").attr("id","table-nav").append(s.addClass("pagination pull-right").prepend(a("<li/>").addClass("disabled").data("page","previous").append(a('<a href="#" />').append(a("<span/>").attr("aria-hidden","true").html("&laquo;")).append(a("<span/>").addClass("sr-only").text(x.previousText)))).append(a("<li/>").addClass("disabled").data("page","next").append(a('<a href="#" />').append(a("<span/>").attr("aria-hidden","true").html("&raquo;")).append(a("<span/>").addClass("sr-only").text(x.nextText))))))}function C(e){a("#search").on("keyup",function(){a.each(e.find("tr"),function(){var e=a(this).text().replace(/ /g,"").replace(/(\r\n|\n|\r)/gm,""),t=a("#search").val();-1==e.toLowerCase().indexOf(t.toLowerCase())?a(this).hide().removeClass("search-item"):a(this).show().addClass("search-item"),r=""!=t?!0:!1}),g(e),v(),m(e,1)})}function g(a){t=r?Math.ceil(a.children(".search-item").length/n):Math.ceil(a.children("tr").length/n),0==t&&(t=1)}function m(s,d){"next"==d?d=e+1:"previous"==d&&(d=e-1),e=d;var i=r?s.find(".search-item"):s.find("tr"),l=n*d,o=l-n,p=a(".pagination");i.hide(),i.slice(o,l).show(),p.find("li").removeClass("active disabled"),p.find("li:eq("+d+")").addClass("active"),1==d?p.find("li:first").addClass("disabled"):d==t&&p.find("li:last").addClass("disabled")}var x=a.extend({pageRowCount:5,arrowDown:"fa-angle-down",arrowUp:"fa-angle-up",searchFormClass:"pull-left search-form",pageFieldText:"Entries per Page:",searchFieldText:"Search",showSearchForm:1,showEntriesPerPageField:1,nextText:"Next",previousText:"Previous"},h),w=null;return this.each(function(){d=a(this).addClass("bdt"),w=d.find("tbody"),n=x.pageRowCount,l=x.arrowDown,i=x.arrowUp,o=x.searchFormClass,p=x.pageFieldText,c=x.searchFieldText;var t,s;1==x.showSearchForm&&(t=a("<form/>").addClass(o).attr("role","form").append(a("<div/>").addClass("form-group").append(a("<input/>").addClass("form-control").attr("id","search").attr("placeholder",c)))),1==x.showEntriesPerPageField&&(s=a("<form/>").addClass("form-horizontal").attr("id","page-rows-form").append(a("<label/>").addClass("pull-left control-label").text(p)).append(a("<div/>").addClass("pull-left").append(a("<select/>").addClass("form-control").append(a("<option>",{value:5,text:5})).append(a("<option>",{value:5,text:5,selected:"selected"})).append(a("<option>",{value:15,text:15})).append(a("<option>",{value:20,text:20})).append(a("<option>",{value:25,text:25}))))),d.before(a("<div/>").addClass("table-header").append(t).append(a("<div/>").addClass("pull-left").append(s))),d.after(a("<div/>").attr("id","table-footer").append(a("<div/>").addClass("pull-left table-info"))),w.children("tr").length>n&&(g(w),v(),m(w,e)),C(w),u(d,w),a("body").on("click",".pagination li",function(e){var t;t=a(e.target).is("a")?a(e.target).parent():a(e.target).parent().parent();var n=t.data("page");t.hasClass("disabled")||t.hasClass("active")||m(w,n),e.preventDefault()}),a("#page-rows-form").on("change",function(){var e=a(this).find("select");n=e.val(),g(w),v(),m(w,1)})})}}(jQuery);

/**
 * jQuery.fn.sortElements
 * --------------
 * @author James Padolsey (http://james.padolsey.com)
 */
jQuery.fn.sortElements=function(){var t=[].sort;return function(e,n){n=n||function(){return this};var r=this.map(function(){var t=n.call(this),e=t.parentNode,r=e.insertBefore(document.createTextNode(""),t.nextSibling);return function(){if(e===this)throw new Error("You can't sort elements if any one is a descendant of another.");e.insertBefore(this,r),e.removeChild(r)}});return t.call(this,e).each(function(t){r[t].call(n.call(this))})}}();