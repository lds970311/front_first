(function (global, factory) {
    typeof exports === 'object' && typeof module !== 'undefined' ? module.exports = factory() :
        typeof define === 'function' && define.amd ? define(factory) :
            (global = global || self, global.Vue = factory());
}(this, (function () {
    'use strict';

    var commonjsGlobal = typeof globalThis !== 'undefined' ? globalThis : typeof window !== 'undefined' ? window : typeof global !== 'undefined' ? global : typeof self !== 'undefined' ? self : {};

    function unwrapExports(x) {
        return x && x.__esModule && Object.prototype.hasOwnProperty.call(x, 'default') ? x['default'] : x;
    }

    function createCommonjsModule(fn, module) {
        return module = {exports: {}}, fn(module, module.exports), module.exports;
    }

    var init = createCommonjsModule(function (module, exports) {
        Object.defineProperty(exports, "__esModule", {value: true});
        exports.initMixin = void 0;

        function initMixin(Vue) {
            Vue.prototype._init = function (options) {
                const vm = this;
                if (options && options._isComponent) ;
                else {
                    vm.$options = options;
                }
                if (vm.$options.el) {
                    vm.$mount(vm.$options.el);
                }
            };
        }

        exports.initMixin = initMixin;
    });

    unwrapExports(init);
    var init_1 = init.initMixin;

    var instance = createCommonjsModule(function (module, exports) {
        Object.defineProperty(exports, "__esModule", {value: true});

        function Vue(options) {
            console.log("vue is here!!");
            this._init(options);
        }

        (0, init.initMixin)(Vue);
        exports.default = Vue;
    });

    unwrapExports(instance);

    var core = createCommonjsModule(function (module, exports) {
        var __importDefault = (commonjsGlobal && commonjsGlobal.__importDefault) || function (mod) {
            return (mod && mod.__esModule) ? mod : {"default": mod};
        };
        Object.defineProperty(exports, "__esModule", {value: true});
        const index_1 = __importDefault(instance);
        exports.default = index_1.default;
    });

    unwrapExports(core);

    var runtime = createCommonjsModule(function (module, exports) {
        var __importDefault = (commonjsGlobal && commonjsGlobal.__importDefault) || function (mod) {
            return (mod && mod.__esModule) ? mod : {"default": mod};
        };
        Object.defineProperty(exports, "__esModule", {value: true});
        const index_1 = __importDefault(core);
        exports.default = index_1.default;
    });

    var Vue = unwrapExports(runtime);

    var util = createCommonjsModule(function (module, exports) {
        Object.defineProperty(exports, "__esModule", {value: true});
        exports.query = void 0;

        function query(el) {
            if (typeof el === 'string') {
                const selected = document.querySelector(el);
                if (!selected) {
                    console.error("el mount error!");
                    return document.createElement('div');
                }
                return selected;
            } else {
                return el;
            }
        }

        exports.query = query;
    });

    unwrapExports(util);
    var util_1 = util.query;

    //CREATE AT: 2021-12-18

    Vue.prototype.$mount = function (el, hydrating) {
        el = el && util_1(el);
        console.log("mounted", el);
    };

    return Vue;

})));
