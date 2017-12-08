webpackJsonp([8],{0:function(e,t,a){(function(e){"use strict";function t(e){return e&&e.__esModule?e:{"default":e}}var r=a(1),l=t(r),n=a(17),o=t(n),i=a(62),s=a(13),u=(t(s),a(11));o["default"].render(l["default"].createElement(u.Grid,null,l["default"].createElement(u.Row,{className:"show-grid"},l["default"].createElement(u.Col,{xs:8,md:8,className:"editForm"},l["default"].createElement(u.Panel,{header:pageParas.title},l["default"].createElement("div",{id:"tableRoot"},"loading..."))),l["default"].createElement(u.Col,{xs:10,md:10}))),document.getElementById("root"));var d=e("#tableRoot").get(0);o["default"].render(l["default"].createElement(i.EditFormD3,pageParas),d)}).call(t,a(16))},24:function(e,t){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a={};a.checkDateTime=function(){var e=arguments.length<=0||void 0===arguments[0]?"":arguments[0],t=arguments.length<=1||void 0===arguments[1]?"yyyy-mm-dd hh:mm:ss":arguments[1];if("yyyy-mm-dd hh:mm:ss"==t){var a=/^(\d+)-(\d{1,2})-(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/,r=e.match(a);if(null==r)return!1;r[2]=r[2]-1;var l=new Date(r[1],r[2],r[3],r[4],r[5],r[6]);return l.getFullYear()==r[1]&&(l.getMonth()==r[2]&&(l.getDate()==r[3]&&(l.getHours()==r[4]&&(l.getMinutes()==r[5]&&l.getSeconds()==r[6]))))}if("yyyy-mm-dd"==t){var a=/^(\d+)-(\d{1,2})-(\d{1,2})$/,r=e.match(a);if(null==r)return!1;r[2]=r[2]-1;var l=new Date(r[1],r[2],r[3]);return l.getFullYear()==r[1]&&(l.getMonth()==r[2]&&l.getDate()==r[3])}},t["default"]=a},27:function(e,t,a){(function(e,r){"use strict";function l(e){return e&&e.__esModule?e:{"default":e}}function n(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}function o(e,t){if(!e)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return!t||"object"!=typeof t&&"function"!=typeof t?e:t}function i(e,t){if("function"!=typeof t&&null!==t)throw new TypeError("Super expression must either be null or a function, not "+typeof t);e.prototype=Object.create(t&&t.prototype,{constructor:{value:e,enumerable:!1,writable:!0,configurable:!0}}),t&&(Object.setPrototypeOf?Object.setPrototypeOf(e,t):e.__proto__=t)}function s(e){return function(t){return x(w(t,e),e)}}Object.defineProperty(t,"__esModule",{value:!0}),t.SelectAddHintRow=t.HintRow=t.HintInput=t.ComplexRow=t.CityValuePairRow=t.SelectGroup=t.TypeValuePairRow=t.SelectAddableRow=t.SimpleRow=void 0;var u=a(21),d=l(u),p=a(19),c=l(p),h=a(1),f=l(h),v=a(20),m=l(v),y=Object.assign||function(e){for(var t=1;t<arguments.length;t++){var a=arguments[t];for(var r in a)Object.prototype.hasOwnProperty.call(a,r)&&(e[r]=a[r])}return e},g=function(){function e(e,t){for(var a=0;a<t.length;a++){var r=t[a];r.enumerable=r.enumerable||!1,r.configurable=!0,"value"in r&&(r.writable=!0),Object.defineProperty(e,r.key,r)}}return function(t,a,r){return a&&e(t.prototype,a),r&&e(t,r),t}}(),S=a(11),b=a(13),E=(l(b),a(24)),k=l(E),C={SimpleRow:{displayName:"SimpleRow"},SelectGroup:{displayName:"SelectGroup"}},x=(0,m["default"])({filename:"D:/tools/tools/components/EditableRow.js",components:C,locals:[e],imports:[f["default"]]}),w=(0,c["default"])({filename:"D:/tools/tools/components/EditableRow.js",components:C,locals:[],imports:[f["default"],d["default"]]}),_=s("SimpleRow")(function(e){function t(e){n(this,t);var a=o(this,(t.__proto__||Object.getPrototypeOf(t)).call(this,e));a.result={};var r="unknown";a.props.validator||(r="");var l={name:a.props.name,value:a.props.value,validateState:r};return a.props.type&&"select"==a.props.type&&(l.value=l.value||a.props.options[0]),a.props.type&&"checkbox"==a.props.type&&(l.value=l.value||0),a.state={data:l},a}return i(t,e),g(t,[{key:"componentDidMount",value:function(){}},{key:"validate",value:function(){var e=this.state.data;if("error"==e.validateState)return!1;if("unknown"==e.validateState){this.validateAndSetState(e);return"error"!=e.validateState}return!0}},{key:"changeValue",value:function(e){if(this.props.onChange)return void this.props.onChange(e);var t=this.state.data;t.value=e.target.value,this.validateAndSetState(t)}},{key:"onCheck",value:function(e){var t=this.state.data;t.value=e.target.checked,t.value?t.value=1:t.value=0,this.setState({data:t})}},{key:"validateAndSetState",value:function(e){var t=this.validateByValue(e.value);return Object.assign(e,t),this.setState({data:e}),t}},{key:"validateByValue",value:function(e){if(!this.props.validator)return!0;var t={errorMessage:"",validateState:""};if(1==this.props.validator.notNull&&""===r.trim(e)&&(t.validateState="error",t.errorMessage="字段不能为空"),this.props.validator.dataType)switch(this.props.validator.dataType){case"number":""!=!e||r.isNumeric(e)||(t.validateState="error",t.errorMessage="请填写数字");break;case"email":var a=/.*@.+\..+/;""!=!e||a.test(e)||(t.validateState="error",t.errorMessage="请填写正确邮箱格式");break;case"mobile":r.isNumeric(e)&&11==e.length||(t.validateState="error",t.errorMessage="请填写正确的手机号码");break;case"time":k["default"].checkDateTime(e,this.props.validator.pattern)||(t.validateState="error",t.errorMessage="请填写正确时间类型，例如:2016-01-01")}var l,n;return(l=this.props.validator.minLength)&&e&&e.length<l&&(t.validateState="error",t.errorMessage="字段最小长度应大于"+l),(n=this.props.validator.maxLength)&&e&&e.length>n&&(t.validateState="error",t.errorMessage="字段最大长度不能大于"+n),t.value=e,t}},{key:"getResult",value:function(){var e={};return e[this.state.data.name]=this.state.data.value,e}},{key:"render",value:function(){var e,t=this,a=this.props.type,r={placeholder:this.props.placeholder,defaultValue:this.props.value,name:this.props.name,type:a,style:{marginTop:"5px"}},l={overflow:"hidden",margin:"10px 0"};if(a)switch(a){case"delete":return null;case"textArea":case"textarea":r.componentClass="textarea";break;case"checkbox":r={},r.componentClass="checkbox";var n=[];return"1"!=this.props.value&&1!=this.props.value&&1!=this.props.value||(n.checked="true"),this.props.readOnly&&(n.disabled="disabled"),f["default"].createElement(S.FormGroup,{bgSize:"lg",controlId:this.props.id,style:l,validationState:this.state.data.validateState},f["default"].createElement(S.Col,{sm:2,style:{textAlign:"right",paddingTop:"10px"},componentClass:S.ControlLabel},o,this.props.alias||this.props.name),f["default"].createElement(S.Col,{sm:10},f["default"].createElement(S.Checkbox,y({name:this.props.name,onClick:this.onCheck.bind(this),style:{marginLeft:"10px"}},n),"点选",n)));case"readOnly":r.value=r.defaultValue,delete r.defaultValue,r.readOnly=!0;break;case"hidden":l.display="none",r.type="hidden";break;case"select":r.componentClass="select",e=this.props.options.map(function(e,t){return f["default"].createElement("option",{value:e},e)})}else r.type="text";this.props.readOnly&&(r.value=r.defaultValue,delete r.defaultValue,r.readOnly=!0);var o="";return this.props.validator&&this.props.validator.notNull&&(o="* "),f["default"].createElement(S.FormGroup,{bgSize:"lg",controlId:this.props.id,style:l,validationState:this.state.data.validateState},f["default"].createElement(S.Col,{sm:2,style:{textAlign:"right",paddingTop:"10px"},componentClass:S.ControlLabel},o,this.props.alias||this.props.name),f["default"].createElement(S.Col,{sm:10},f["default"].createElement(S.FormControl,y({},r,{onChange:this.changeValue.bind(this),inputRef:function(e){t.input=e}}),e),f["default"].createElement(S.HelpBlock,null,this.state.data.errorMessage),f["default"].createElement(S.FormControl.Feedback,{style:{right:"15px",top:"4px"}})))}}]),t}(h.Component)),O=s("SelectGroup")(function(e){function t(e){n(this,t);var a=o(this,(t.__proto__||Object.getPrototypeOf(t)).call(this,e));return a.state={categoryTwoOptions:a.props.selector.categoryTwo[a.props.selectGroup[0].value||"组长"],data:{category:a.props.selectGroup[0].value||"组长",categoryTwo:a.props.selectGroup[1].value||"注射剂"}},a}return i(t,e),g(t,[{key:"validate",value:function(){return!0}}]),g(t,[{key:"getResult",value:function(){return this.state.data}},{key:"change",value:function(e){this.setState({categoryTwoOptions:this.props.selector.categoryTwo[e.target.value],data:{category:e.target.value,categoryTwo:this.props.selector.categoryTwo[e.target.value][0]}})}},{key:"changeTwo",value:function(e){this.setState({data:{category:this.state.data.category,categoryTwo:e.target.value}})}},{key:"render",value:function(){return f["default"].createElement("div",null,f["default"].createElement(_,{name:this.props.selectGroup[0].name,alias:this.props.selectGroup[0].alias,value:this.state.data.category,options:this.props.selector.category,type:"select",onChange:this.change.bind(this)}),f["default"].createElement(_,{name:this.props.selectGroup[1].name,alias:this.props.selectGroup[1].alias,value:this.state.data.categoryTwo,options:this.state.categoryTwoOptions,onChange:this.changeTwo.bind(this),type:"select"}))}}]),t}(h.Component)),M=(function(e){function t(e){n(this,t);var a=o(this,(t.__proto__||Object.getPrototypeOf(t)).call(this,e));return a.result={},a.state={data:null},a}return i(t,e),g(t,[{key:"componentDidMount",value:function(e){var t=[];t.push({value:this.props.value,type:this.props.selectorValue||this.props.category||this.props.type||this.props.selector[0],validateState:""});var a={name:this.props.name};a.value=t,this.setState({data:a})}},{key:"addSub",value:function(){var e=this.state.data;e.value.push({value:"",type:this.props.selector[0],validateState:""}),this.setState({data:e})}},{key:"deleteSub",value:function(e){var t=this.state.data;t.value.splice(e,1),this.setState({data:t})}},{key:"validate",value:function(){var e=!0,t=this.state.data;for(var a in t.value)if("error"==t.value[a].validateState)e=!1;else if("unknown"==t.value[a].validateState||""==t.value[a].validateState){var r=this.validateAndSetState(t.value[a]);Object.assign(t.value[a],r),"error"==r.validateState&&(e=!1)}return this.setState({data:t}),e}},{key:"changeValue",value:function(e,t){var a=this.state.data;a.value[e].value=t.target.value;var r=this.validateByValue(t.target.value);Object.assign(a.value[e],r),this.setState({data:a})}},{key:"changeType",value:function(e,t){var a=this.state.data;a.value[e].type=t.target.value,this.setState({data:a})}},{key:"getResult",value:function(){var e={},t=this.state.data.value,a=[],r="num",l="category";this.props.columnNames&&(r=this.props.columnNames[0]||"num",l=this.props.columnNames[1]||"category");for(var n in t){var o={};o[r]=t[n].value,o[l]=t[n].type,a.push(o)}return e[this.props.name]=a,e}},{key:"render",value:function(){if(this.state.data){var e=(this.props.type,this.props.selector.map(function(e,t){return f["default"].createElement("option",{value:e},e)})),t={overflow:"hidden",margin:"10px 0"},a="";this.props.validator&&this.props.validator.notNull&&(a="* ");var r=this,l=this.state.data.value.map(function(a,l){var n,o=f["default"].createElement(S.Button,{onClick:r.deleteSub.bind(r,l)},"-");return 0==l&&(n=r.props.alias||r.props.name,o=f["default"].createElement(S.Button,{onClick:r.addSub.bind(r)},"+")),f["default"].createElement(S.FormGroup,{bgSize:"lg",controlId:r.props.id,style:t,validationState:a.validateState},f["default"].createElement(S.Col,{sm:2,style:{textAlign:"right",marginTop:"10px"},componentClass:S.ControlLabel},n),f["default"].createElement(S.Col,{sm:5,style:{textAlign:"right",paddingTop:"5px"},componentClass:S.ControlLabel},f["default"].createElement(S.FormControl,{value:a.type,componentClass:"select",onChange:r.changeType.bind(r,l)},e)),f["default"].createElement(S.Col,{sm:4},f["default"].createElement(S.FormControl,{style:{textAlign:"left",marginTop:"5px"},value:a.value,type:"text",onChange:r.changeValue.bind(r,l)}),f["default"].createElement(S.HelpBlock,null,a.errorMessage),f["default"].createElement(S.FormControl.Feedback,{style:{right:"15px",top:"4px"}})),f["default"].createElement(S.Col,{sm:1,style:{textAlign:"center",padding:"5px 0px"},componentClass:S.ControlLabel},o))});return f["default"].createElement("div",null,l)}return f["default"].createElement("div",null)}}]),t}(_),function(e){function t(e){n(this,t);var a=o(this,(t.__proto__||Object.getPrototypeOf(t)).call(this,e));return a.result={},a.state={data:null},a}return i(t,e),g(t,[{key:"componentDidMount",value:function(e){var t=[];t.push({value:this.props.value,type:this.props.selectorValue||this.props.category||this.props.type||this.props.selector[0],validateState:""});var a={name:this.props.name};a.value=t,this.setState({data:a})}},{key:"addSub",value:function(){var e=this.state.data;e.value.push({value:"",type:this.props.selector[0],validateState:""}),this.setState({data:e})}},{key:"deleteSub",value:function(e){var t=this.state.data;t.value.splice(e,1),this.setState({data:t})}},{key:"validate",value:function(){var e=!0,t=this.state.data;for(var a in t.value)if("error"==t.value[a].validateState)e=!1;else if("unknown"==t.value[a].validateState||""==t.value[a].validateState){var r=this.validateAndSetState(t.value[a]);Object.assign(t.value[a],r),"error"==r.validateState&&(e=!1)}return this.setState({data:t}),e}},{key:"changeValue",value:function(e,t){var a=this.state.data;a.value[e].value=t.target.value;var r=this.validateByValue(t.target.value);Object.assign(a.value[e],r),this.setState({data:a})}},{key:"changeType",value:function(e,t){var a=this.state.data;a.value[e].type=t.target.value,this.setState({data:a})}},{key:"getResult",value:function(){var e={},t=this.state.data.value,a=[],r="num",l="category";this.props.columnNames&&(r=this.props.columnNames[0]||"num",l=this.props.columnNames[1]||"category");for(var n in t){var o={};o[r]=t[n].value,o[l]=t[n].type,a.push(o)}return e[this.props.name]=a,e}},{key:"render",value:function(){if(this.state.data){var e=(this.props.type,this.props.selector.map(function(e,t){return f["default"].createElement("option",{value:e},e)})),t={overflow:"hidden",margin:"10px 0"},a="";this.props.validator&&this.props.validator.notNull&&(a="* ");var r=this,l=this.state.data.value.map(function(a,l){var n,o=f["default"].createElement(S.Button,{onClick:r.deleteSub.bind(r,l)},"-");return 0==l&&(n=r.props.alias||r.props.name,o=f["default"].createElement(S.Button,{onClick:r.addSub.bind(r)},"+")),f["default"].createElement(S.FormGroup,{bgSize:"lg",controlId:r.props.id,style:t,validationState:a.validateState},f["default"].createElement(S.Col,{sm:2,style:{textAlign:"right",marginTop:"10px"},componentClass:S.ControlLabel},n),f["default"].createElement(S.Col,{sm:5,style:{textAlign:"right",paddingTop:"5px"},componentClass:S.ControlLabel},f["default"].createElement(S.FormControl,{value:a.type,componentClass:"select",onChange:r.changeType.bind(r,l)},e)),f["default"].createElement(S.Col,{sm:4},f["default"].createElement(S.FormControl,{style:{textAlign:"left",marginTop:"5px"},value:a.value,type:"text",onChange:r.changeValue.bind(r,l)}),f["default"].createElement(S.HelpBlock,null,a.errorMessage),f["default"].createElement(S.FormControl.Feedback,{style:{right:"15px",top:"4px"}})),f["default"].createElement(S.Col,{sm:1,style:{textAlign:"center",padding:"5px 0px"},componentClass:S.ControlLabel},o))});return f["default"].createElement("div",null,l)}return f["default"].createElement("div",null)}}]),t}(_)),j=function(e){function t(e){n(this,t);var a=o(this,(t.__proto__||Object.getPrototypeOf(t)).call(this,e));return a.result={},a.state={data:{value:[{category:"",num:"1",validateState:"unknown"}]}},console.log(a.props),a}return i(t,e),g(t,[{key:"componentDidMount",value:function(e){}},{key:"addSub",value:function(){var e=this.state.data;e.value.push({category:"",num:"1",validateState:"unknown"}),this.setState({data:e})}},{key:"changeValue",value:function(e,t){if(this.props.onChange)return void this.props.onChange(t);var a=this.state.data;a.value[e].num=t.target.value,this.validateAndSetState(e,a)}},{key:"validateAndSetState",value:function(e,t){var a=this.validateByValue(t.value[e].num);Object.assign(t.value[e],a),this.setState({data:t})}},{key:"validate",value:function(){var e=!0,t=this.state.data;for(var a in t.value){if(0==this.refs["hintInput"+a].validate())return!1;if("error"==t.value[a].validateState||"unknown"==this.refs["hintInput"+a].state.validateState||"error"==this.refs["hintInput"+a].state.validateState)e=!1;else if("unknown"==t.value[a].validateState||""==t.value[a].validateState){var r=this.validateAndSetState(t.value[a]);Object.assign(t.value[a],r),"error"==r.validateState&&(e=!1)}}return this.setState({data:t}),e}},{key:"getResult",value:function(){var e=this.state.data.value;for(var t in e)e[t].category=this.refs["hintInput"+t].state.data.value,delete e[t].validateState,delete e[t].type,delete e[t].value,delete e[t].errorMessage;return{zuyuan:e}}},{key:"render",value:function(){if(this.state.data){var e=(this.props.type,{position:"relative",marginBottom:"0px"}),t="";this.props.validator&&this.props.validator.notNull&&(t="* ");var a=this,r=this.state.data.value.map(function(t,r){var l,n=f["default"].createElement(S.Button,{onClick:a.deleteSub.bind(a,r)},"-");return 0==r&&(l=a.props.alias||a.props.name,n=f["default"].createElement(S.Button,{onClick:a.addSub.bind(a)},"+")),f["default"].createElement(S.FormGroup,{bgSize:"lg",controlId:a.props.id,style:e,validationState:t.validateState},f["default"].createElement(S.Col,{sm:2,style:{textAlign:"right",marginTop:"10px"},componentClass:S.ControlLabel},l),f["default"].createElement(S.Col,{sm:7,style:{textAlign:"right"},componentClass:S.ControlLabel},f["default"].createElement(B,y({ref:"hintInput"+r},a.props))),f["default"].createElement(S.Col,{sm:2},f["default"].createElement(S.FormControl,{style:{textAlign:"left",marginTop:"5px"},defaultValue:t.num,type:"text",onChange:a.changeValue.bind(a,r)}),f["default"].createElement(S.HelpBlock,null,t.errorMessage),f["default"].createElement(S.FormControl.Feedback,{style:{right:"15px",top:"4px"}})),f["default"].createElement(S.Col,{sm:1,style:{textAlign:"center",padding:"5px 0px"},componentClass:S.ControlLabel},n),f["default"].createElement("div",{style:{clear:"both"}}))});return f["default"].createElement("div",null,r)}return f["default"].createElement("div",null)}}]),t}(M),T=function(e){function t(){return n(this,t),o(this,(t.__proto__||Object.getPrototypeOf(t)).apply(this,arguments))}return i(t,e),g(t,[{key:"componentDidMount",value:function(e){}},{key:"render",value:function(){var e={overflow:"hidden",margin:"10px 0"},t=this,a=this.props.value.map(function(a,r){return f["default"].createElement(S.FormGroup,{bgSize:"lg",controlId:t.props.id,style:e,validationState:a.validateState},f["default"].createElement(S.Col,{sm:2,style:{textAlign:"right",marginTop:"10px"},componentClass:S.ControlLabel},a.category),f["default"].createElement(S.Col,{sm:4,style:{textAlign:"right",paddingTop:"5px"},componentClass:S.ControlLabel},f["default"].createElement(S.FormControl,{value:a.categoryTwo,readOnly:"true",type:"text"})),f["default"].createElement(S.Col,{sm:6,style:{textAlign:"left",marginTop:"5px"}},f["default"].createElement(S.FormControl,{value:a.num,readOnly:"true",type:"text"})))});return f["default"].createElement("div",null,a)}}]),t}(M),F=function(e){function t(e){n(this,t);var a=o(this,(t.__proto__||Object.getPrototypeOf(t)).call(this,e));return a.state={data:{attribution:"",work:"",validateState:"unknown",validateState2:"unknown",validateStatetemp:"unknown"}},a}return i(t,e),g(t,[{key:"changeCity",value:function(e){var t=this.state.data;t.attribution=e.target.value,this.validateAndSetState(t,"attribution")}},{key:"changeValue",value:function(e){var t=this.state.data;t.work=e.target.value,this.validateAndSetState(t,"value")}},{key:"validate",value:function(){var e=this.state.data;if("error"==e.validateState||"error"==e.validateState2)return!1;if("unknown"==e.validateState||"unknown"==e.validateState2){var t=this.validateAndSetState(e);if("error"==t.validateState)return!1;var a=this.validateAndSetState(e,"attribution");return"error"!=a.validateState2}return!0}},{key:"validateByCity",value:function(e){var t={errorMessage2:"",validateState2:""};return""!=e&&"-选择归属地"!=e||(t.errorMessage2="请选择归属地",t.validateState2="error"),t}},{key:"validateAndSetState",value:function(e){var t,a=arguments.length<=1||void 0===arguments[1]?"value":arguments[1];return t="value"==a?this.validateByValue(e.work):this.validateByCity(e.attribution),Object.assign(e,t),this.setState({data:e}),t}},{key:"getResult",value:function(){var e=this.state.data;return e.work=this.state.data.work,e.attribution=this.state.data.attribution,e}},{key:"render",value:function(){var e={placeholder:this.props.placeholder,value:this.props.value,name:this.props.name,type:"text",style:{marginTop:"5px"}},t={overflow:"hidden",margin:"10px 0"},a=["-选择归属地","省直","哈尔滨市"].map(function(e,t){return f["default"].createElement("option",{value:e},e)}),r=this;return f["default"].createElement(S.FormGroup,{bgSize:"lg",controlId:r.props.id,style:t,validationState:this.state.data.validateState},f["default"].createElement(S.Col,{sm:2,style:{textAlign:"right",marginTop:"10px"},componentClass:S.ControlLabel},"*",this.props.alias||this.props.name),f["default"].createElement(S.Col,{sm:3,style:{textAlign:"right",paddingTop:"5px"}},f["default"].createElement(S.FormControl,{componentClass:"select",ref:"city",onChange:this.changeCity.bind(this)},a),f["default"].createElement(S.HelpBlock,null,this.state.data.errorMessage2)),f["default"].createElement(S.Col,{sm:7},f["default"].createElement(S.FormControl,y({},e,{onChange:this.changeValue.bind(this)})),f["default"].createElement(S.HelpBlock,null,this.state.data.errorMessage),f["default"].createElement(S.FormControl.Feedback,{style:{right:"15px",top:"4px"}})))}}]),t}(_),A=function(e){function t(){return n(this,t),o(this,(t.__proto__||Object.getPrototypeOf(t)).apply(this,arguments))}return i(t,e),g(t,[{key:"validate",value:function(){return!0}},{key:"getResult",value:function(){var e={};for(var t in this.refs)Object.assign(e,e,this.refs[t].getResult());var a={};return this.props.value instanceof Array?(a[this.props.name]=[],a[this.props.name].push(e)):a[this.props.name]=e,a}},{key:"render",value:function(){var e,t=(this.props.type,{name:this.props.name,style:{marginTop:"5px"}},{overflow:"hidden",margin:"10px 0"});e=this.props.value instanceof Array?this.props.value[0]:this.props.value;var a=[],r=0;for(var l in e)l in this.props.hiddens||(a.push(f["default"].createElement(_,{name:l,alias:this.props.aliasDict[l],value:e[l],ref:"_"+r})),r++);return f["default"].createElement(S.FormGroup,{bgSize:"lg",controlId:this.props.id,style:t,validationState:this.state.data.validateState},f["default"].createElement(S.Col,{sm:2,style:{textAlign:"right",paddingTop:"10px"},componentClass:S.ControlLabel},this.props.alias||this.props.name),f["default"].createElement(S.Col,{sm:10},a))}}]),t}(_),R={"float":"left",paddingLeft:8,position:"absolute",minHeight:50,width:250,zIndex:1e4,borderWidth:1,borderColor:"#ddd",borderStyle:"solid",listStyle:"none",backgroundColor:"#fff",top:"34px",left:"0px",textAlign:"left"},P=function(e){function t(){return n(this,t),o(this,(t.__proto__||Object.getPrototypeOf(t)).apply(this,arguments))}return i(t,e),g(t,[{key:"getResult",value:function(){return console.log(this.refs.hintInput),this.refs.hintInput.getResult()}},{key:"render",value:function(){var e="";this.props.validator&&this.props.validator.notNull&&(e="* ");var t={position:"relative",marginBottom:"0px"};return f["default"].createElement("div",null,f["default"].createElement(S.FormGroup,{bgSize:"lg",controlId:this.props.id,style:t,validationState:this.state.data.validateState},f["default"].createElement(S.Col,{sm:2,style:{textAlign:"right",marginTop:"10px"},componentClass:S.ControlLabel},e,this.props.alias||this.props.name),f["default"].createElement(S.Col,{sm:10},f["default"].createElement(B,y({},this.props,{ref:"hintInput"}))),f["default"].createElement("div",{style:{clear:"both"}})))}}]),t}(_),B=function(e){function t(e){n(this,t);var a=o(this,(t.__proto__||Object.getPrototypeOf(t)).call(this,e)),r="unknown";a.props.validator||(r=""),a.index=0;var l={name:a.props.name,value:a.props.value,validateState:r};return console.log(a.props.department),"undefined"==typeof a.props.department?a.initWords=["计算机科学与技术","电子科学与技术","机械电子工程／生物医学工程（医疗机器人与仪器研究）","机械电子工程（康复医疗器械的研究）","机械电子工程","控制科学与工程","控制理论与控制工程","光电子技术、光物理","光学工程","药学检验","药理检验","临床检验","检验","医学检验","放射诊断","放射线、核医学","医学影像及放射线","超声诊断（影像医学）","超声诊断","口腔专业医疗设备仪器维修","肾脏疾病","肾内科、血液净化","中医外科临床教学","中医康复","中西医结合神经内科","中西医结合外科","中西医结合科","中西医结合耳鼻喉","免疫","神经病","精神科","肿瘤科","肿瘤血液","血液肿瘤科风湿科","血液病","血管外科","心血管内科","神经外科","神经内科","临床试验管理办公室","皮肤科","骨科","骨外科","妇产科","产科","消化、内分泌、腔镜","消化内科","内分泌科","老年呼吸科","物理诊断科","实验诊断部","口腔科","耳鼻喉科","呼吸内科","儿内科","感染内科","康复科","整形科","计算机中心","烧伤科"]:6==a.props.department?a.initWords=["临床","药剂学","内科","针灸","药品检验","药剂学","药理","消化内科","心血管","心内科","呼吸科","肾内科","肛肠","神经内科","肾病科","针灸推拿","针灸康复","中医内科","心内科","骨科","妇科","乳腺外科","心内科","耳鼻咽喉","风湿病科","呼吸科","消化科","皮肤科","骨科","眼病","神经外科","骨伤科","风湿科","儿科","骨科","临床药学科","神经内科","心内科","耳鼻喉科","中医妇科","肛肠外科","内分泌科","皮肤科","普外科","肾病科","血液病科","药理毒理","眼科","神经内科","急诊科","妇产科","肿瘤内科","胸外科","骨外科","妇科学","呼吸内科","老年病科","心内科","临床药学科","肿瘤内科","乳腺肿瘤科","神经肿瘤科","肿瘤胸外科","肿瘤外科","皮肤科"]:a.initWords=["计算机科学与技术","电子科学与技术","机械电子工程／生物医学工程（医疗机器人与仪器研究）","机械电子工程（康复医疗器械的研究）","机械电子工程","控制科学与工程","控制理论与控制工程","光电子技术、光物理","光学工程","药学检验","药理检验","临床检验","检验","医学检验","放射诊断","放射线、核医学","医学影像及放射线","超声诊断（影像医学）","超声诊断","口腔专业医疗设备仪器维修","肾脏疾病","肾内科、血液净化","中医外科临床教学","中医康复","中西医结合神经内科","中西医结合外科","中西医结合科","中西医结合耳鼻喉","免疫","神经病","精神科","肿瘤科","肿瘤血液","血液肿瘤科风湿科","血液病","血管外科","心血管内科","神经外科","神经内科","临床试验管理办公室","皮肤科","骨科","骨外科","妇产科","产科","消化、内分泌、腔镜","消化内科","内分泌科","老年呼吸科","物理诊断科","实验诊断部","口腔科","耳鼻喉科","呼吸内科","儿内科","感染内科","康复科","整形科","计算机中心","烧伤科"],a.state={data:l,searchInfo:"",errorMessage:""},a}return i(t,e),g(t,[{key:"changeValue",value:function(e){if(this.props.onChange)return void this.props.onChange(e);var t=this.state.data;t.value=e.target.value,this.validateAndSetState(t),this.searchKeyword(e)}},{key:"validate",value:function(){var e=this.state.data;if(this.checkedValueExist(),"error"==e.validateState)return!1;if("unknown"==e.validateState){this.validateAndSetState(e);return"error"!=e.validateState}return!0}},{key:"liClickSelected",value:function(e){var t=this.state.data;t.value=e.target.innerText,this.validateAndSetState(t),this.setState({searchInfo:""}),this.checkedValueExist()}},{key:"handleKeyPress",value:function(e){var t=e.keyCode,a=r(".selected>li");a.removeClass("active");r(".selected>li:first-child"),r(".selected>li:last-child");if(40==t){if(this.index==r(".selected>li").length)return;r(a[this.index]).addClass("active"),this.index++}if(38==t){if(0==this.index)return;this.index--,r(a[this.index-1]).addClass("active")}if(13==t){this.setState({searchInfo:""});var l=this.state.data;l.value=r(".selected>li")[this.index-1].innerText,this.validateAndSetState(l),this.index=0,this.checkedValueExist()}}},{key:"checkedValueExist",value:function(){for(var e=this.state.data,t=e.value,a=!1,l=0;l<this.initWords.length;l++)if(t==this.initWords[l]){a=!0;break}a?(this.setState({errorMessage:""}),e.validateState=""):this.setState({errorMessage:"字段不存在，请重新输入"}),""===r.trim(e.value)&&this.setState({errorMessage:"字段不能为空"})}},{key:"searchKeyword",value:function(e){this.index=0;var t=e.target.value;if(""==t)return void this.setState({searchInfo:""});var a=this.initWords.filter(function(e){return e.indexOf(t)>-1});this.setState({searchInfo:a})}},{key:"genUl",value:function(e){if(""==e)return"";var t=this,a=0,r=e.map(function(e){return a++,f["default"].createElement("li",{key:a,onClick:t.liClickSelected.bind(t)},e)});return f["default"].createElement("ul",{className:"selected",style:R},r)}},{key:"render",value:function(){var e=this.props.type,t={placeholder:this.props.placeholder,value:this.state.data.value,name:this.props.name,type:e,style:{marginTop:"5px"}},a={marginBottom:"0px"};t.type="text";var r="";this.props.validator&&this.props.validator.notNull&&(r="* ");var l=this.genUl(this.state.searchInfo);return f["default"].createElement("div",{id:"hintInput",style:{position:"relative"}},f["default"].createElement(S.FormGroup,{bgSize:"lg",controlId:this.props.id,style:a,validationState:this.state.data.validateState},f["default"].createElement(S.Col,null,f["default"].createElement(S.FormControl,y({},t,{onBlur:this.checkedValueExist.bind(this),onChange:this.changeValue.bind(this),onKeyDown:this.handleKeyPress.bind(this)})),f["default"].createElement(S.HelpBlock,{style:{textAlign:"left",fontWeight:"normal",color:"#a94442"}},this.state.errorMessage),f["default"].createElement(S.FormControl.Feedback,{style:{right:"15px",top:"4px"}}))),l)}}]),t}(_);t.SimpleRow=_,t.SelectAddableRow=M,t.TypeValuePairRow=T,t.SelectGroup=O,t.CityValuePairRow=F,t.ComplexRow=A,t.HintInput=B,t.HintRow=P,t.SelectAddHintRow=j}).call(t,a(18)(e),a(16))},39:function(e,t,a){(function(e,r){"use strict";function l(e){return e&&e.__esModule?e:{"default":e}}function n(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}function o(e,t){if(!e)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return!t||"object"!=typeof t&&"function"!=typeof t?e:t}function i(e,t){if("function"!=typeof t&&null!==t)throw new TypeError("Super expression must either be null or a function, not "+typeof t);e.prototype=Object.create(t&&t.prototype,{constructor:{value:e,enumerable:!1,writable:!0,configurable:!0}}),t&&(Object.setPrototypeOf?Object.setPrototypeOf(e,t):e.__proto__=t)}function s(e){return function(t){return w(_(t,e),e)}}Object.defineProperty(t,"__esModule",{value:!0}),t.EditFormWithStandardResp=void 0;var u=a(21),d=l(u),p=a(19),c=l(p),h=a(1),f=l(h),v=a(20),m=l(v),y=Object.assign||function(e){for(var t=1;t<arguments.length;t++){var a=arguments[t];for(var r in a)Object.prototype.hasOwnProperty.call(a,r)&&(e[r]=a[r])}return e},g=function(){function e(e,t){for(var a=0;a<t.length;a++){var r=t[a];r.enumerable=r.enumerable||!1,r.configurable=!0,"value"in r&&(r.writable=!0),Object.defineProperty(e,r.key,r)}}return function(t,a,r){return a&&e(t.prototype,a),r&&e(t,r),t}}(),S=a(11),b=a(13),E=l(b),k=a(24),C=(l(k),a(27)),x={EditForm:{displayName:"EditForm"}},w=(0,m["default"])({filename:"D:/tools/tools/components/EditForm.js",components:x,locals:[e],imports:[f["default"]]}),_=(0,c["default"])({filename:"D:/tools/tools/components/EditForm.js",components:x,locals:[],imports:[f["default"],d["default"]]}),O=s("EditForm")(function(e){function t(e){n(this,t);var a=o(this,(t.__proto__||Object.getPrototypeOf(t)).call(this,e));return a.state={data:null,modalShow:!1,redirectFlag:!1},a}return i(t,e),g(t,[{key:"componentDidMount",value:function(){if("put"==this.props.method){var e=this;r.ajax({type:"get",dataType:"json",url:this.props.url,success:function(e){var t=E["default"].fillFormInit(e,this.props.formInit);E["default"].mergeData(t,this.props.formExtend),this.setState({data:t,modalMethod:"alert",modalShow:!1,modalMessage:"操作成功"})}.bind(this),error:function(t){e.setState({modalShow:!1,modalMethod:"alert",modalMessage:"操作失败"})}})}else if("post"==this.props.method){var t=this.props.formInit;E["default"].mergeData(t,this.props.formExtend),this.setState({data:t})}}},{key:"default_success_callback",value:function(e){var t,a={modalMethod:"alert",modalShow:!0};1==e.status?(t="操作成功"+(e.message?":"+e.message:""),a.redirectFlag="true"):t="操作失败"+(e.message?":"+e.message:""),a.modalMessage=t,this.setState(a)}},{key:"ajaxSubmit",value:function(e,t,a){var l=this.default_success_callback.bind(this),n=this;r.ajax({type:e,url:t,data:JSON.stringify(a),dataType:"json",contentType:"application/json",success:l,error:function(e){n.setState({modalMethod:"alert",modalShow:!0,modalMessage:"操作失败"})}})}},{key:"submit",value:function(){var e=this.dataWrap();this.validate()&&this.ajaxSubmit(this.props.method,this.props.url,e)}},{key:"dataWrap",value:function(){var e={},t=this.refs;for(var a in t)Object.assign(e,t[a].getResult());return e}},{key:"confirm",value:function(){"update"==this.state.modalMethod?this.submit():"delete"==this.state.modalMethod&&this["delete"](),this.setState({modalShow:!1
})}},{key:"closeModal",value:function(){this.setState({modalShow:!1}),this.state.redirectFlag&&(this.props.redirectUrl?window.location=this.props.redirectUrl:location.reload())}},{key:"validate",value:function(){var e=this.refs,t=!0;for(var a in e)0==e[a].validate()&&(t=!1);return t}},{key:"delete",value:function(){var e=this.dataWrap();this.ajaxSubmit("delete",this.props.url,e)}},{key:"genRows",value:function(e){var t=this;return e.map(function(e){return e.selectGroup?f["default"].createElement(C.SelectGroup,y({ref:e.name},e)):e.group&&"groupList"!=e.group?f["default"].createElement(C.SelectAddableRow,y({ref:e.name},e,{selector:t.props.selector[e.group]})):e.type&&"hintgroup"==e.type?f["default"].createElement(C.SelectAddHintRow,y({ref:e.name},e,{selector:t.props.selector[e.group]})):e.validator&&e.validator.dataType&&"location"==e.validator.dataType?f["default"].createElement(C.CityValuePairRow,y({ref:e.name},e)):e.type&&"complexRow"==e.type?f["default"].createElement(C.ComplexRow,y({ref:e.name},e)):e.type&&"hint"==e.type?f["default"].createElement(C.HintRow,y({ref:e.name},e)):f["default"].createElement(C.SimpleRow,y({ref:e.name},e))})}},{key:"genButtons",value:function(){var e=this;if(1!=this.props.noButton)return"put"==this.props.method?f["default"].createElement("div",null,f["default"].createElement(S.Button,{onClick:function(){return e.setState({modalShow:!0,modalMessage:"确认修改?",modalMethod:"update"})},bsStyle:"primary",style:{marginTop:"10px"}},"修改"),f["default"].createElement(S.Button,{onClick:function(){return e.setState({modalShow:!0,modalMessage:"确认删除?",modalMethod:"delete"})},style:{margin:"10px 0 0 20px"}},"删除")):"post"==this.props.method?f["default"].createElement("div",null,f["default"].createElement(S.Button,{onClick:this.submit.bind(this),bsStyle:"primary",style:{marginTop:"10px",padding:"5px 20px 5px 20px"}},"确认")):void 0}},{key:"render",value:function(){var e,t;e=this.genButtons(),t="alert"==this.state.modalMethod?f["default"].createElement(S.Button,{onClick:this.closeModal.bind(this)},"关闭"):f["default"].createElement("div",null,f["default"].createElement(S.Button,{bsStyle:"primary",onClick:this.confirm.bind(this)},"确认"),f["default"].createElement(S.Button,{onClick:this.closeModal.bind(this)},"关闭"));var a=this.state.data;if(!a)return f["default"].createElement("div",null,"loading...");var r=this.genRows(a);return f["default"].createElement("form",null,r,f["default"].createElement(S.FormGroup,null,f["default"].createElement(S.Col,{md:12,lg:12,style:{textAlign:"center"}},e)),f["default"].createElement("div",{className:"modal-container"},f["default"].createElement(S.Modal,{show:this.state.modalShow,onHide:this.closeModal.bind(this),container:this,"aria-labelledby":"contained-modal-title"},f["default"].createElement(S.Modal.Body,null,this.state.modalMessage),f["default"].createElement(S.Modal.Footer,{style:{textAlign:"center"}},t))))}}]),t}(h.Component)),M=function(e){function t(){return n(this,t),o(this,(t.__proto__||Object.getPrototypeOf(t)).apply(this,arguments))}return i(t,e),g(t,[{key:"componentDidMount",value:function(){if("put"==this.props.method){var e=this;r.ajax({type:"get",dataType:"json",url:this.props.url,success:function(e){var t=E["default"].fillFormInit(e.data,this.props.formInit);E["default"].mergeData(t,this.props.formExtend),this.setState({data:t,modalMethod:"alert",modalShow:!1,modalMessage:"操作成功"})}.bind(this),error:function(t){e.setState({modalShow:!1,modalMethod:"alert",modalMessage:"操作失败"})}})}else if("post"==this.props.method){var t=this.props.formInit;E["default"].mergeData(t,this.props.formExtend),this.setState({data:t})}}}]),t}(O);t["default"]=O,t.EditFormWithStandardResp=M}).call(t,a(18)(e),a(16))},62:function(e,t,a){"use strict";function r(e){return e&&e.__esModule?e:{"default":e}}function l(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}function n(e,t){if(!e)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return!t||"object"!=typeof t&&"function"!=typeof t?e:t}function o(e,t){if("function"!=typeof t&&null!==t)throw new TypeError("Super expression must either be null or a function, not "+typeof t);e.prototype=Object.create(t&&t.prototype,{constructor:{value:e,enumerable:!1,writable:!0,configurable:!0}}),t&&(Object.setPrototypeOf?Object.setPrototypeOf(e,t):e.__proto__=t)}Object.defineProperty(t,"__esModule",{value:!0}),t.EditFormD3=t.EditFormD2=void 0;var i=function S(e,t,a){null===e&&(e=Function.prototype);var r=Object.getOwnPropertyDescriptor(e,t);if(void 0===r){var l=Object.getPrototypeOf(e);return null===l?void 0:S(l,t,a)}if("value"in r)return r.value;var n=r.get;if(void 0!==n)return n.call(a)},s=Object.assign||function(e){for(var t=1;t<arguments.length;t++){var a=arguments[t];for(var r in a)Object.prototype.hasOwnProperty.call(a,r)&&(e[r]=a[r])}return e},u=function(){function e(e,t){for(var a=0;a<t.length;a++){var r=t[a];r.enumerable=r.enumerable||!1,r.configurable=!0,"value"in r&&(r.writable=!0),Object.defineProperty(e,r.key,r)}}return function(t,a,r){return a&&e(t.prototype,a),r&&e(t,r),t}}(),d=a(1),p=r(d),c=(a(11),a(13)),h=(r(c),a(24)),f=(r(h),a(39)),v=r(f),m=a(27),y=function(e){function t(){return l(this,t),n(this,(t.__proto__||Object.getPrototypeOf(t)).apply(this,arguments))}return o(t,e),u(t,[{key:"genRows",value:function(e){var t=this;return e.map(function(e){return e.group?p["default"].createElement(m.SelectAddableRow,s({ref:e.name},e,{selector:t.props.selector[e.group]})):p["default"].createElement(m.SimpleRow,s({ref:e.name},e))})}}]),t}(v["default"]),g=function(e){function t(){return l(this,t),n(this,(t.__proto__||Object.getPrototypeOf(t)).apply(this,arguments))}return o(t,e),u(t,[{key:"dataWrap",value:function(){var e=[],a=i(t.prototype.__proto__||Object.getPrototypeOf(t.prototype),"dataWrap",this).call(this);for(var r in a)if("生产组人数"==r||"质量组人数"==r){var l={};l.num=a[r],l.category=r.substr(0,3),e.push(l),delete a[r]}return e&&(a.groupList=e),a.bacteria?a.bacteria="1":a.bacteria="0",a}}]),t}(v["default"]);t.EditFormD2=y,t.EditFormD3=g}});