;(function($, window, document,undefined) {

    //定义Adapt的构造函数
    var Adapt = function(ele, opt) {
        this.$element = ele,
        this.$windowHeight=window.screen.availHeight;
        this.$windowWeight=window.screen.availWidth;

        this.defaults = {
            "offsetHeight":0,
            "offsetWidth":0
        },
        this.options = $.extend({}, this.defaults, opt)
    }
    //定义Adapt的方法
    Adapt.prototype = {
        init:function(){
            $(this.$element).height(this.$windowHeight-(this.options.offsetHeight))

        }
    }

    //在插件中使用Adapt对象
    $.fn.adapt = function(options) {
        //创建Adapt的实体
        var adapt = new Adapt(this, options);
        //调用其方法
        return adapt.init();
    }

})(jQuery, window, document);