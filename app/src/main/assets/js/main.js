var LaLady = (function () {
    function LaLady() {
        var _this = this;
        this.$el = {};
        $(function () {
            _this.$el.intro = $("#intro");
            _this.$el.finder = $("#finder");
            _this.$el.suspend = $("#suspend");
            _this.$el.processing = $("#processing");
            _this.$el.finderList = $("#finder ul");
            _this.reset();
        });
        $("#suspend").on({
            "click": function () {
                _this.toIntro();
            }
        });
        $("#select-employee").on({
            "click": function () {
                _this.toSelectEmployee();
            }
        });
    }
    LaLady.prototype.morphSight = function (arg) {
        var $TGT = $("#sight");
        $TGT
            .removeClass()
            .addClass((!arg) ? "" : arg);
    };
    LaLady.prototype.aura = function (arg) {
        var $TGT = $("#aura");
        $TGT
            .removeClass()
            .addClass((!arg) ? "" : arg);
    };
    LaLady.prototype.pulse = function () {
    };
    LaLady.prototype.toIntro = function () {
        var _this = this;
        this.aura("");
        this.morphSight("intro");
        this.$el.suspend.fadeOut();
        setTimeout(function () {
            _this.$el.intro.fadeIn();
        }, 200);
    };
    LaLady.prototype.toSelectEmployee = function () {
        var _this = this;
        this.$el.finderList.empty();
        this.$el.finder.addClass("progress");
        this.$el.intro.fadeOut("fast", "linear", function () {
            _this.morphSight("dialog");
            setTimeout(function () {
                _this.$el.finder.fadeIn();
            }, 200);
            setTimeout(function () {
                _this.$el.finder.removeClass("progress");
                for (var i = 0, il = 100; i < il; i++) {
                    var $li = $("<li />").addClass("button");
                    $li.on({ "click": function () {
                            _this.toCalling();
                        } });
                    $li.html("<div class=\"photo\"><img src=\"#\"></div><div class=\"text\"><span class=\"name\">\u9577\u8C37\u5DDD\u30FB\u30B8\u30A7\u30FC\u30E0\u30B9\u30FB\u753A\u5B50</span><span class=\"division\">\u30B7\u30B9\u30C6\u30E0\u8D85\u7D76\u958B\u767A\u5BA4</span></div>");
                    _this.$el.finderList.append($li);
                }
            }, 2000);
        });
    };
    LaLady.prototype.toCalling = function () {
        var _this = this;
        this.$el.finder.fadeOut();
        this.aura("progress");
        setTimeout(function () {
            _this.morphSight("progress");
            _this.$el.processing.fadeIn();
        }, 200);
    };
    LaLady.prototype.reset = function () {
        this.morphSight();
        this.$el.intro.hide();
        this.$el.finder.hide();
        this.$el.processing.hide();
        this.aura("suspend");
    };
    return LaLady;
})();
var $lady = new LaLady();
//# sourceMappingURL=main.js.map