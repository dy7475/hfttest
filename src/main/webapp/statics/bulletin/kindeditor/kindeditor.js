/*******************************************************************************
* KindEditor - WYSIWYG HTML Editor for Internet
*
* @author Roddy <luolonghao@gmail.com>
* @site http://www.kindsoft.net/
* @licence LGPL(http://www.opensource.org/licenses/lgpl-license.php)
* @version 3.3.1
*******************************************************************************/

var biaoqingPath = "hftWebService/bulletinNew/kindeditor/";
var KE = {};
var KE_ID;
KE.version = '3.3.1';

KE.lang = {
    source : '切换模式',
    preview : '预览',
    undo : '后退(Ctrl+Z)',
    redo : '前进(Ctrl+Y)',
    fontname : '字体',
    fontsize : '文字大小',
    bold : '粗体',
    italic : '斜体',
    underline : '下划线',
    strikethrough : '删除线',
    removeformat : '删除格式',
    image : '插入图片',
    flash : '插入Flash',
    table : '插入表格',
    hr : '插入横线',
    emoticons : '插入笑脸',
    link : '超级连接',
    unlink : '取消超级连接',
    fullscreen : '全屏显示',
    about : '关于',
    insertHouseInfo : '插入我的房源',
    yes : '确定',
    no : '取消',
    close : '关闭',
    invalidImg : "请输入有效的URL地址。\n只允许jpg,gif,bmp,png格式。",
    invalidMedia : "请输入有效的URL地址。\n只允许mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb格式。",
    invalidWidth : "宽度必须为数字。",
    invalidHeight : "高度必须为数字。",
    invalidBorder : "边框必须为数字。",
    invalidUrl : "URL不正确。",
    pleaseInput : "请输入内容"
};
function getRelativePath(){
	var elements = document.getElementsByTagName('script');
	for (var i = 0, len = elements.length; i < len; i++) {
		if (elements[i].src && elements[i].src.match(/kindeditor[\w\-\.]*\.js/)) {
			return elements[i].src.substring(0, elements[i].src.lastIndexOf('/') + 1);
		}
	}
	return "";	
}
KE.scriptPath = (function() {
    var elements = document.getElementsByTagName('script');
    for (var i = 0, len = elements.length; i < len; i++) {
        if (elements[i].src && elements[i].src.match(/kindeditor[\w\-\.]*\.js/)) {
            return elements[i].src.substring(0, elements[i].src.lastIndexOf('/') + 1);
        }
    }
    return "";
})();

KE.htmlPath = (function() {
    return location.href.substring(0, location.href.lastIndexOf('/') + 1);
})();

KE.browser = (function() {
    var ua = navigator.userAgent.toLowerCase();
    if (ua.indexOf("msie") > -1) return 'IE';
    else if (ua.indexOf("webkit") > -1) return 'WEBKIT';
    else if (ua.indexOf("gecko") > -1) return 'GECKO';
    else if (ua.indexOf("opera") > -1) return 'OPERA';
    else return "";
})();

KE.setting = {
    wyswygMode : true,
    autoOnsubmitMode : true,
    resizeMode : 0,//设置编辑器是否可以调整大小

    filterMode : true,
    tagLineMode : false,
    skinType : 'default',
    cssPath : '',
    skinsPath : KE.scriptPath + 'skins/',
    pluginsPath : KE.scriptPath + 'plugins/',
    minWidth : 200,
    minHeight : 100,
    minChangeSize : 5,
    imgServerUrl : basePath+"pic/hftpic/house/",//设置图片服务器的默认路径
    //huanyq2008修改
    items : [
        'fullscreen',/**'fontname', 'bold', 'italic', 'underline',*/ 'image', 'flash',
        'emoticons','insertHouseInfo',
        'link', 'unlink','hr', 'about'
    ],
    //自定义颜色表
    colorTable : [
        ["#000000","#993300","#333300","#003300","#003366","#000080","#333399","#333333"],
        ["#800000","#FF6600","#808000","#008000","#008080","#0000FF","#666699","#808080"],
        ["#FF0000","#FF9900","#99CC00","#339966","#33CCCC","#3366FF","#800080","#999999"],
        ["#FF00FF","#FFCC00","#FFFF00","#00FF00","#00FFFF","#00CCFF","#993366","#C0C0C0"],
        ["#FF99CC","#FFCC99","#FFFF99","#CCFFCC","#CCFFFF","#99CCFF","#CC99FF","#FFFFFF"]
    ],
    noEndTags : ['br', 'hr', 'img', 'area', 'col', 'embed', 'input', 'param'],
    inlineTags : ['b', 'del', 'em', 'font', 'i', 'span', 'strike', 'strong', 'sub', 'sup', 'u'],
    htmlTags : {
        font : ['color', 'size', 'face', '.background-color'],
        span : [
            '.color', '.background-color', '.font-size', '.font-family',
            '.font-weight', '.font-style', '.text-decoration', '.vertical-align'
        ],
        div : [
            'class', 'align', '.border', '.margin', '.padding', '.text-align', '.color',
            '.background-color', '.font-size', '.font-family', '.font-weight',
            '.font-style', '.text-decoration', '.vertical-align', '.margin-left'
        ],
        table: [
            'class', 'border', 'cellspacing', 'cellpadding', 'width', 'height', 'align',
            '.padding', '.margin', '.border', 'bgcolor', '.text-align', '.color', '.background-color',
            '.font-size', '.font-family', '.font-weight', '.font-style', '.text-decoration'
        ],
        'td,th': [
            'class', 'align', 'valign', 'width', 'height', 'colspan', 'rowspan', 'bgcolor',
            '.text-align', '.color', '.background-color', '.font-size', '.font-family', '.font-weight',
            '.font-style', '.text-decoration', '.vertical-align'
        ],
        a : ['class', 'href', 'target', 'name'],
        embed : ['src', 'width', 'height', 'type', 'loop', 'autostart', 'quality', '.width', '.height', 'align', 'allowscriptaccess', '/'],
        img : ['src', 'width', 'height', 'border', 'alt', 'title', '.width', '.height', '/'],
        hr : ['class', '/'],
        br : ['/'],
        'p,ol,ul,li,blockquote,h1,h2,h3,h4,h5,h6' : [
            'align', '.text-align', '.color', '.background-color', '.font-size', '.font-family',
            '.font-weight', '.font-style', '.text-decoration', '.vertical-align', '.text-indent', '.margin-left'
        ],
        'tbody,tr,strong,b,sub,sup,em,i,u,strike' : []
    }
};

KE.g = {};

KE.plugin = {};

KE.$ = function(id, doc){
    var doc = doc || document;
    return doc.getElementById(id);
};

KE.$$ = function(name, doc){
    var doc = doc || document;
    return doc.createElement(name);
};

KE.event = {
    add : function(el, event, listener) {
        if (el.addEventListener){
            el.addEventListener(event, listener, false);
        } else if (el.attachEvent){
            el.attachEvent('on' + event, listener);
        }
    },
    remove : function(el, event, listener) {
        if (el.removeEventListener){
            el.removeEventListener(event, listener, false);
        } else if (el.detachEvent){
            el.detachEvent('on' + event, listener);
        }
    },
    input : function(el, func) {
        this.add(el, 'keyup', function(e) {
            if (!e.ctrlKey && !e.shiftKey && !e.altKey && (e.keyCode < 16 || e.keyCode > 18) && e.keyCode != 116) {
                func(e);
                return false;
            }
        });
    },
    ctrl : function(el, key, func) {
        this.add(el, 'keydown', function(e) {
            if (e.ctrlKey && e.keyCode == key.toUpperCase().charCodeAt(0) && !e.shiftKey && !e.altKey) {
                func(e);
                return false;
            }
        });
    },
    ready : function(func) {
        var loaded = false;
        var readyFunc = function() {
            if (loaded) return;
            loaded = true;
            func();
        };
        if (document.addEventListener) {
            this.add(document, "DOMContentLoaded", readyFunc);
        } else if (document.attachEvent){
            this.add(document, "readystatechange", function() {
                if (document.readyState == "complete") readyFunc();
            });
            if ( document.documentElement.doScroll && typeof window.frameElement === "undefined" ) {
                var ieReadyFunc = function() {
                    if (loaded) return;
                    try {
                        document.documentElement.doScroll("left");
                    } catch(e) {
                        setTimeout(ieReadyFunc, 0);
                        return;
                    }
                    readyFunc();
                };
                ieReadyFunc();
            }
        }
        this.add(window, 'load', readyFunc);
    }
};

KE.each = function(obj, func) {
    for (var key in obj) {
        if (obj.hasOwnProperty(key)) func(key, obj[key]);
    }
};

KE.eachNode = function(node, func) {
    var walkNodes = function(parent) {
        if (KE.util.getNodeType(parent) != 1) return true;
        var n = parent.firstChild;
        while (n != null) {
            var next = n.nextSibling;
            if (!func(n)) return false;
            if (!walkNodes(n)) return false;
            n = next;
        }
        return true;
    };
    walkNodes(node);
};

KE.selection = function(win, doc) {
    this.sel = null;
    this.range = null;
    this.keRange = null;
    this.init = function() {
        var sel = win.getSelection ? win.getSelection() : doc.selection;
        var range;
        try {
            if (sel.rangeCount > 0) range = sel.getRangeAt(0);
            else range = sel.createRange();
        } catch(e) {}
        if (!range) range = KE.util.createRange(doc);
        this.sel = sel;
        this.range = range;
        var startNode, startPos, endNode, endPos;
        if (KE.browser == 'IE') {
            if (range.item) {
                var el = range.item(0);
                startNode = endNode = el;
                startPos = endPos = 0;
            } else {
                var getStartEnd = function(isStart) {
                    var pointRange = range.duplicate();
                    pointRange.collapse(isStart);
                    var parentNode = pointRange.parentElement();
                    var nodes = parentNode.childNodes;
                    if (nodes.length == 0) return {node: parentNode, pos: 0};
                    var startNode;
                    var endElement;
                    var startPos = 0;
                    var isEnd = false;
                    var testRange = range.duplicate();
                    testRange.moveToElementText(parentNode);
                    for (var i = 0, len = nodes.length; i < len; i++) {
                        var node = nodes[i];
                        var cmp = testRange.compareEndPoints('StartToStart', pointRange);
                        if (cmp > 0) {
                            isEnd = true;
                        } else if (cmp == 0) {
                            if (node.nodeType == 1) {
                                var keRange = new KE.range(doc);
                                keRange.selectTextNode(node);
                                return {node: keRange.startNode, pos: 0};
                            } else {
                                return {node: node, pos: 0};
                            }
                        }
                        if (node.nodeType == 1) {
                            var nodeRange = range.duplicate();
                            nodeRange.moveToElementText(node);
                            testRange.setEndPoint('StartToEnd', nodeRange);
                            if (isEnd) startPos += nodeRange.text.length;
                            else startPos = 0;
                        } else if (node.nodeType == 3) {
                            testRange.moveStart('character', node.nodeValue.length);
                            startPos += node.nodeValue.length;
                        }
                        if (!isEnd) startNode = node;
                    }
                    if (!isEnd && startNode.nodeType == 1) {
                        var startNode = parentNode.lastChild;
                        return {node: startNode, pos: startNode.nodeType == 1 ? 1 : startNode.nodeValue.length};
                    }
                    testRange = range.duplicate();
                    testRange.moveToElementText(parentNode);
                    testRange.setEndPoint('StartToEnd', pointRange);
                    startPos -= testRange.text.replace(/\r\n|\n|\r/g, '').length;
                    return {node: startNode, pos: startPos};
                };
                var start = getStartEnd(true);
                var end = getStartEnd(false);
                startNode = start.node;
                startPos = start.pos;
                endNode = end.node;
                endPos = end.pos;
            }
        } else {
            startNode = range.startContainer;
            startPos = range.startOffset;
            endNode = range.endContainer;
            endPos = range.endOffset;
            if (startNode.nodeType == 1 && typeof startNode.childNodes[startPos] != "undefined") {
                startNode = startNode.childNodes[startPos];
                startPos = startNode.nodeType == 1 ? 0 : startNode.nodeValue.length;
            }
            if (endNode.nodeType == 1 && typeof endNode.childNodes[endPos] != "undefined") {
                endNode = endNode.childNodes[endPos];
                endPos = endNode.nodeType == 1 ? 0 : endNode.nodeValue.length;
            }
        }
        var keRange = new KE.range(doc);
        keRange.setTextStart(startNode, startPos);
        keRange.setTextEnd(endNode, endPos);
        this.keRange = keRange;
    };
    this.init();
    this.addRange = function(keRange) {
        this.keRange = keRange;
        if (KE.browser == 'IE') {
            var getEndRange = function(isStart) {
                var range = KE.util.createRange(doc);
                var node = isStart ? keRange.startNode : keRange.endNode;
                if (node.nodeType == 1) {
                    range.moveToElementText(node);
                    range.collapse(isStart);
                } else if (node.nodeType == 3) {
                    range = KE.util.getNodeStartRange(doc, node);
                    var pos = isStart ? keRange.startPos : keRange.endPos;
                    range.moveStart('character', pos);
                }
                return range;
            }
            if (!this.range.item) {
                var node = keRange.startNode;
                if (node == keRange.endNode && KE.util.getNodeType(node) == 1 && KE.util.getNodeTextLength(node) == 0) {
                    var temp = doc.createTextNode(" ");
                    node.appendChild(temp);
                    this.range.moveToElementText(node);
                    this.range.collapse(false);
                    this.range.select();
                    node.removeChild(temp);
                } else {
                    this.range.setEndPoint('StartToStart', getEndRange(true));
                    this.range.setEndPoint('EndToStart', getEndRange(false));
                    this.range.select();
                }
            }
        } else {
            var range = new KE.range(doc);
            range.setTextStart(keRange.startNode, keRange.startPos);
            range.setTextEnd(keRange.endNode, keRange.endPos);
            this.range.setStart(range.startNode, range.startPos);
            this.range.setEnd(range.endNode, range.endPos);
            this.sel.removeAllRanges();
            this.sel.addRange(this.range);
        }
    };
    this.focus = function() {
        if (KE.browser == 'IE' && this.range != null) this.range.select();
    }
};

KE.range = function(doc) {
    this.startNode = null;
    this.startPos = null;
    this.endNode = null;
    this.endPos = null;
    this.getParentElement = function() {
        var scanParent = function(node, func) {
            while (node != null && node.tagName != 'body') {
                node = node.parentNode;
                if (func(node)) return;
            }
        }
        var nodeList = [];
        scanParent(this.startNode, function(node) {
            nodeList.push(node);
        });
        var parentNode;
        scanParent(this.endNode, function(node) {
            if (KE.util.inArray(node, nodeList)) {
                parentNode = node;
                return true;
            }
        });
        return parentNode ? parentNode : doc.body;
    };
    this.getNodeList = function() {
        var parentNode = this.getParentElement();
        var nodeList = [];
        var keRange = this;
        var startNode = this.startNode;
        var isStarted = false;
        if (parentNode == startNode) isStarted = true;
        if (isStarted) nodeList.push(parentNode);
        KE.eachNode(parentNode, function(node) {
            if (node == startNode) isStarted = true;
            var range = new KE.range(doc);
            range.selectTextNode(node);
            if (range.comparePoints('START_TO_END', keRange) >= 0) return false;
            if (isStarted) nodeList.push(node);
            return true;
        });
        return nodeList;
    };
    this.comparePoints = function(how, range) {
        var compareNodes = function(nodeA, posA, nodeB, posB) {
            var cmp;
            if (KE.browser == 'IE') {
                var getStartRange = function(node, pos, isStart) {
                    var range = KE.util.createRange(doc);
                    var type = KE.util.getNodeType(node);
                    if (type == 1) {
                        range.moveToElementText(node);
                        range.collapse(isStart);
                    } else if (type == 3) {
                        range = KE.util.getNodeStartRange(doc, node);
                        range.moveStart('character', pos);
                        range.collapse(true);
                    }
                    return range;
                }
                var rangeA, rangeB;
                if (how == 'START_TO_START' || how == 'START_TO_END') rangeA = getStartRange(nodeA, posA, true);
                else rangeA = getStartRange(nodeA, posA, false);
                if (how == 'START_TO_START' || how == 'END_TO_START') rangeB = getStartRange(nodeB, posB, true);
                else rangeB = getStartRange(nodeB, posB, false);
                return rangeA.compareEndPoints('StartToStart', rangeB);
            } else {
                var rangeA = KE.util.createRange(doc);
                rangeA.selectNode(nodeA);
                if (how == 'START_TO_START' || how == 'START_TO_END') rangeA.collapse(true);
                else rangeA.collapse(false);
                var rangeB = KE.util.createRange(doc);
                rangeB.selectNode(nodeB);
                if (how == 'START_TO_START' || how == 'END_TO_START') rangeB.collapse(true);
                else rangeB.collapse(false);
                if (rangeA.compareBoundaryPoints(Range.START_TO_START, rangeB) > 0) {
                    cmp = 1;
                } else if (rangeA.compareBoundaryPoints(Range.START_TO_START, rangeB) == 0) {
                    if (posA > posB) cmp = 1;
                    else if (posA == posB) cmp = 0;
                    else cmp = -1;
                } else {
                    cmp = -1;
                }
            }
            return cmp;
        }
        if (how == 'START_TO_START') return compareNodes(this.startNode, this.startPos, range.startNode, range.startPos);
        if (how == 'START_TO_END') return compareNodes(this.startNode, this.startPos, range.endNode, range.endPos);
        if (how == 'END_TO_START') return compareNodes(this.endNode, this.endPos, range.startNode, range.startPos);
        if (how == 'END_TO_END') return compareNodes(this.endNode, this.endPos, range.endNode, range.endPos);
    };
    this.setTextStart = function(node, pos) {
        var textNode = node;
        KE.eachNode(node, function(n) {
            if (KE.util.getNodeType(n) == 3 && n.nodeValue.length > 0) {
                textNode = n;
                pos = 0;
                return false;
            }
            return true;
        });
        this.setStart(textNode, pos);
    };
    this.setStart = function(node, pos) {
        this.startNode = node;
        this.startPos = pos;
        if (this.endNode === null) {
            this.endNode = node;
            this.endPos = pos;
        }
    };
    this.setTextEnd = function(node, pos) {
        var textNode = node;
        KE.eachNode(node, function(n) {
            if (KE.util.getNodeType(n) == 3 && n.nodeValue.length > 0) {
                textNode = n;
                pos = n.nodeValue.length;
            }
            return true;
        });
        this.setEnd(textNode, pos);
    };
    this.setEnd = function(node, pos) {
        this.endNode = node;
        this.endPos = pos;
        if (this.startNode === null) {
            this.startNode = node;
            this.startPos = pos;
        }
    };
    this.selectNode = function(node) {
        this.setStart(node, 0);
        this.setEnd(node, node.nodeType == 1 ? 0 : node.nodeValue.length);
    };
    this.selectTextNode = function(node) {
        this.setTextStart(node, 0);
        this.setTextEnd(node, node.nodeType == 1 ? 0 : node.nodeValue.length);
    };
    this.extractContents = function(isDelete) {
        isDelete = (isDelete === false) ? false : true;
        var thisRange = this;
        var startNode = this.startNode;
        var startPos = this.startPos;
        var endNode = this.endNode;
        var endPos = this.endPos;
        var extractTextNode = function(node, startPos, endPos) {
            var length = node.nodeValue.length;
            var cloneNode = node.cloneNode(true);
            var centerNode = cloneNode.splitText(startPos);
            centerNode.splitText(endPos - startPos);
            if (isDelete) {
                var center = node;
                if (startPos > 0) center = node.splitText(startPos);
                if (endPos < length) center.splitText(endPos - startPos);
                center.parentNode.removeChild(center);
            }
            return centerNode;
        };
        var isStarted = false;
        var isEnd = false;
        var extractNodes = function(parent, frag) {
            if (KE.util.getNodeType(parent) != 1) return true;
            var node = parent.firstChild;
            while (node != null) {
                if (node == startNode) isStarted = true;
                if (node == endNode) isEnd = true;
                var nextNode = node.nextSibling;
                var type = KE.util.getNodeType(node);
                if (type == 1) {
                    var range = new KE.range(doc);
                    range.selectNode(node);
                    if (isStarted && range.comparePoints('END_TO_END', thisRange) < 0) {
                        var cloneNode = node.cloneNode(true);
                        frag.appendChild(cloneNode);
                        if (isDelete) {
                            node.parentNode.removeChild(node);
                        }
                    } else {
                        var childFlag = node.cloneNode(false);
                        frag.appendChild(childFlag);
                        if (!extractNodes(node, childFlag)) return false;
                    }
                } else if (type == 3) {
                    if (isStarted) {
                        var textNode;
                        if (node == startNode && node == endNode) {
                            textNode = extractTextNode(node, startPos, endPos);
                            frag.appendChild(textNode);
                            return false;
                        } else if (node == startNode) {
                            textNode = extractTextNode(node, startPos, node.nodeValue.length);
                            frag.appendChild(textNode);
                        } else if (node == endNode) {
                            textNode = extractTextNode(node, 0, endPos);
                            frag.appendChild(textNode);
                            return false;
                        } else {
                            textNode = extractTextNode(node, 0, node.nodeValue.length);
                            frag.appendChild(textNode);
                        }
                    }
                }
                node = nextNode;
                if (isEnd) return false;
            }
            return true;
        }
        var parentNode = this.getParentElement();
        var docFrag = parentNode.cloneNode(false);
        extractNodes(parentNode, docFrag);
        return docFrag;
    };
    this.cloneContents = function() {
        return this.extractContents(false);
    };
    this.getText = function() {
        var html = this.cloneContents().innerHTML;
        return html.replace(/<.*?>/g, "");
    };
};

KE.cmd = function(id) {
    this.doc = KE.g[id].iframeDoc;
    this.keSel = KE.g[id].keSel;
    this.keRange = KE.g[id].keRange;
    this.mergeAttributes = function(el, attr) {
        for (var i = 0, len = attr.length; i < len; i++) {
            KE.each(attr[i], function(key, value) {
                if (key.charAt(0) == '.') {
                    var jsKey = KE.util.getJsKey(key.substr(1));
                    eval('el.style.' + jsKey + ' = value;');
                } else {
                    el.setAttribute(key, value);
                }
            });
        }
        return el;
    };
    this.wrapTextNode = function(node, startPos, endPos, element, attributes) {
        var length = node.nodeValue.length;
        var isFull = (startPos == 0 && endPos == length);
        var range = new KE.range(this.doc);
        range.selectTextNode(node.parentNode);
        if (isFull &&
            node.parentNode.tagName == element.tagName &&
            range.comparePoints('END_TO_END', this.keRange) <= 0 &&
            range.comparePoints('START_TO_START', this.keRange) >= 0) {
            this.mergeAttributes(node.parentNode, attributes);
            return node;
        } else {
            var el = element.cloneNode(true);
            if (isFull) {
                var cloneNode = node.cloneNode(true);
                el.appendChild(cloneNode);
                node.parentNode.replaceChild(el, node);
                return cloneNode;
            } else {
                var centerNode = node;
                if (startPos < endPos) {
                    if (startPos > 0) centerNode = node.splitText(startPos);
                    if (endPos < length) centerNode.splitText(endPos - startPos);
                    var cloneNode = centerNode.cloneNode(true);
                    el.appendChild(cloneNode);
                    centerNode.parentNode.replaceChild(el, centerNode);
                    return cloneNode;
                } else {
                    if (startPos < length) {
                        centerNode = node.splitText(startPos);
                        centerNode.parentNode.insertBefore(el, centerNode);
                    } else {
                        if (centerNode.nextSibling) {
                            centerNode.parentNode.insertBefore(el, centerNode.nextSibling);
                        } else {
                            centerNode.parentNode.appendChild(el);
                        }
                    }
                    return el;
                }
            }
        }
    };
    this.wrap = function(tagName, attributes) {
        var self = this;
        this.keSel.focus();
        var element = KE.$$(tagName, this.doc);
        this.mergeAttributes(element, attributes);
        var keRange = this.keRange;
        var startNode = keRange.startNode;
        var startPos = keRange.startPos;
        var endNode = keRange.endNode;
        var endPos = keRange.endPos;
        var parentNode = keRange.getParentElement();
        var isStarted = false;
        KE.eachNode(parentNode, function(node) {
            if (node == startNode) isStarted = true;
            if (node.nodeType == 1) {
                if (node == startNode && node == endNode) {
                    if (KE.util.inArray(node.tagName.toLowerCase(), KE.setting.noEndTags)) {
                        if (startPos > 0) node.parentNode.appendChild(element);
                        else node.parentNode.insertBefore(element, node);
                    } else {
                        node.appendChild(element);
                    }
                    keRange.selectNode(element);
                    return false;
                } else if (node == startNode) {
                    keRange.setStart(node, 0);
                } else if (node == endNode) {
                    keRange.setEnd(node, 0);
                    return false;
                }
            } else if (node.nodeType == 3) {
                if (isStarted) {
                    if (node == startNode && node == endNode) {
                        var rangeNode = self.wrapTextNode(node, startPos, endPos, element, attributes);
                        keRange.selectNode(rangeNode);
                        return false;
                    } else if (node == startNode) {
                        var rangeNode = self.wrapTextNode(node, startPos, node.nodeValue.length, element, attributes);
                        keRange.setStart(rangeNode, 0);
                    } else if (node == endNode) {
                        var rangeNode = self.wrapTextNode(node, 0, endPos, element, attributes);
                        keRange.setEnd(rangeNode, rangeNode.nodeType == 1 ? 0 : rangeNode.nodeValue.length);
                        return false;
                    } else {
                        self.wrapTextNode(node, 0, node.nodeValue.length, element, attributes);
                    }
                }
            }
            return true;
        });
        this.keSel.addRange(keRange);
    };
    this.getTopParent = function(tagNames, node) {
        var parent = null;
        while (node != null) {
            node = node.parentNode;
            if (KE.util.inArray(node.tagName.toLowerCase(), tagNames)) {
                parent = node;
            } else {
                break;
            }
        }
        return parent;
    };
    this.splitNodeParent = function(parent, node, pos) {
        var leftRange = new KE.range(this.doc);
        leftRange.selectNode(parent.firstChild);
        leftRange.setEnd(node, pos);
        var leftFrag = leftRange.extractContents();
        parent.parentNode.insertBefore(leftFrag, parent);
        return {left : leftFrag, right : parent};
    };
    this.remove = function(tagNames, attributes) {
        var keRange = this.keRange;
        var startNode = keRange.startNode;
        var startPos = keRange.startPos;
        var endNode = keRange.endNode;
        var endPos = keRange.endPos;
        this.keSel.focus();
        if (keRange.getText().replace(/\s+/g, '') === '') return;
        var startParent = this.getTopParent(tagNames, startNode);
        var endParent = this.getTopParent(tagNames, endNode);
        if (startParent) {
            var startFrags = this.splitNodeParent(startParent, startNode, startPos);
            keRange.setStart(startFrags.right, 0);
            if (startNode == endNode && KE.util.getNodeTextLength(startFrags.right) > 0) {
                keRange.selectNode(startFrags.right);
                var range = new KE.range(this.doc);
                range.selectTextNode(startFrags.left);
                if (startPos > 0) endPos -= range.endNode.nodeValue.length;
                range.selectTextNode(startFrags.right);
                endNode = range.startNode;
            }
        }
        if (endParent) {
            var endFrags = this.splitNodeParent(endParent, endNode, endPos);
            this.keRange.setEnd(endFrags.left, 0);
            if (startParent == endParent) {
                keRange.setStart(endFrags.left, 0);
            }
        }
        var nodeList = keRange.getNodeList();
        keRange.setTextStart(keRange.startNode, keRange.startPos);
        keRange.setTextEnd(keRange.endNode, keRange.endPos);
        for (var i = 0; i < nodeList.length; i++) {
            var node = nodeList[i];
            if (node.nodeType == 1) {
                if (KE.util.inArray(node.tagName.toLowerCase(), tagNames)) {
                    KE.util.removeParent(node);
                } else {
                    for (var j = 0; j < attributes.length; j++) {
                        node.removeAttribute(attributes[j]);
                    }
                }
            }
        }
        try {
            this.keSel.addRange(keRange);
        } catch(e) {}
    };
};

KE.format = {
    getHtml : function(html, htmlTags) {
        var isFilter = (typeof htmlTags == "undefined") ? false : true;
        var domain = document.domain;
        var htmlTagHash = {};
        if (isFilter) {
            KE.each(htmlTags, function(key, val) {
                var arr = key.split(',');
                for (var i = 0, len = arr.length; i < len; i++) htmlTagHash[arr[i]] = KE.util.arrayToHash(val);
            });
        }
        var noEndTagHash = KE.util.arrayToHash(KE.setting.noEndTags);
        var inlineTagHash = KE.util.arrayToHash(KE.setting.inlineTags);
        html = html.replace(/<(\/)?(\w+)(.*?)(\/)?>/g, function($0, $1, $2, $3, $4) {
            var startSlash = $1 || '';
            var tagName = $2.toLowerCase();
            var attr = $3 || '';
            var endSlash = $4 || '';
            if (isFilter && typeof htmlTagHash[tagName] == "undefined") return '';
            if (endSlash === '' && typeof noEndTagHash[tagName] != "undefined") endSlash = ' /';
            var nl = '';
            if (KE.browser == 'IE' && endSlash && typeof inlineTagHash[tagName] == "undefined") nl = "\r\n";
            if (attr !== '') {
                attr = attr.replace(/\s*([^\s]+?)=(".*?"|[^\s]*)/g, function($0, $1, $2) {
                    var key = $1.toLowerCase();
                    var val = $2 || '';
                    if (isFilter) {
                        if (key.charAt(0) === "." || (key !== "style" && typeof htmlTagHash[tagName][key] == "undefined")) return ' ';
                    }
                    if (val === '') {
                        val = '""';
                    } else {
                        if (key === "style") {
                            val = val.substr(1, val.length - 2);
                            val = val.replace(/\s*([^\s]+?)\s*:(.*?)(;|$)/g, function($0, $1, $2) {
                                var k = $1.toLowerCase();
                                if (isFilter) {
                                    if (typeof htmlTagHash[tagName]['.' + k] == "undefined") return '';
                                }
                                var v = KE.util.trim($2.toLowerCase());
                                v = KE.util.rgbToHex(v);
                                return k + ':' + v + ';';
                            });
                            val = KE.util.trim(val);
                            if (val === '') return '';
                            val = '"' + val + '"';
                        }
                        val = val.replace(/http:\/\/(.*?)\//g, function($0, $1) {
                            if ($1 === domain) return '/';
                            else return $0;
                        });
                        if (val.charAt(0) !== '"') val = '"' + val + '"';
                    }
                    return ' ' + key + '=' + val + ' ';
                });
                attr = attr.replace(/\s+(checked|selected|disabled|readonly)(\s+|$)/ig, function($0, $1) {
                    var key = $1.toLowerCase();
                    if (isFilter) {
                        if (key.charAt(0) === "." || typeof htmlTagHash[tagName][key] == "undefined") return ' ';
                    }
                    return ' ' + key + '="' + key + '"' + ' ';
                });
                attr = KE.util.trim(attr);
                attr = attr.replace(/\s+/g, ' ');
                if (attr) attr = ' ' + attr;
                return '<' + startSlash + tagName + attr + endSlash + '>' + nl;
            } else {
                return '<' + startSlash + tagName + endSlash + '>' + nl;
            }
        });
        var reg = KE.setting.inlineTags.join('|');
        var trimHtml = function(inHtml) {
            var outHtml = inHtml.replace(new RegExp('<(' + reg + ')[^>]*><\\/(' + reg + ')>', 'ig'), function($0, $1, $2) {
                if ($1 == $2) return '';
                else return $0;
            });
            if (inHtml !== outHtml) outHtml = trimHtml(outHtml);
            return outHtml;
        };
        return trimHtml(html);
    }
};

KE.util = {
    getDocumentElement : function(doc) {
        doc = doc || document;
        return (doc.compatMode != "CSS1Compat") ? doc.body : doc.documentElement;
    },
    getDocumentHeight : function() {
        var el = this.getDocumentElement();
        return Math.max(el.scrollHeight, el.clientHeight);
    },
    getDocumentWidth : function() {
        var el = this.getDocumentElement();
        return Math.max(el.scrollWidth, el.clientWidth);
    },
    createTable : function() {
        var table = KE.$$('table');
        table.cellPadding = 0;
        table.cellSpacing = 0;
        table.border = 0;
        return {table: table, cell: table.insertRow(0).insertCell(0)};
    },
    /**
     * 调用此方法可以自己创建行，列（避免调用createTable产生的无用行）
     * 奂永桥
     */
    createMyfun7Table : function() {
        var table = KE.$$('table');
        table.cellPadding = 0;
        table.cellSpacing = 0;
        table.border = 0;
        return {table: table};
    },
    loadStyle : function(path) {
        var link = KE.$$('link');
        link.setAttribute('type', 'text/css');
        link.setAttribute('rel', 'stylesheet');
        link.setAttribute('href', path);
        document.getElementsByTagName("head")[0].appendChild(link);
    },
    inArray : function(str, arr) {
        for (var i = 0; i < arr.length; i++) {if (str == arr[i]) return true;}
        return false;
    },
    trim : function(str) {
        return str.replace(/^\s+|\s+$/g, "");
    },
    getJsKey : function(key) {
        var arr = key.split('-');
        key = '';
        for (var i = 0, len = arr.length; i < len; i++) {
            key += (i > 0) ? arr[i].charAt(0).toUpperCase() + arr[i].substr(1) : arr[i];
        }
        return key;
    },
    arrayToHash : function(arr) {
        var hash = {};
        for (var i = 0, len = arr.length; i < len; i++) hash[arr[i]] = 1;
        return hash;
    },
    escape : function(html) {
        html = html.replace(/&/g, "&amp;");
        html = html.replace(/</g, "&lt;");
        html = html.replace(/>/g, "&gt;");
        html = html.replace(/\xA0/g, "&nbsp;");
        html = html.replace(/\x20/g, " ");
        return html;
    },
    getElementPos : function(el) {
        var x = 0;
        var y = 0;
        if (KE.browser != "WEBKIT") {
            var box = el.getBoundingClientRect();
            var el = this.getDocumentElement();
            x = box.left + el.scrollLeft - el.clientLeft;
            y = box.top + el.scrollTop - el.clientTop;
        } else {
            x = el.offsetLeft;
            y = el.offsetTop;
            var parent = el.offsetParent;
            while (parent) {
                x += parent.offsetLeft;
                y += parent.offsetTop;
                parent = parent.offsetParent;
            }
        }
        return {'x' : x, 'y' : y};
    },
    getCoords : function(ev, doc) {
        ev = ev || window.event;
        var el = this.getDocumentElement(doc);
        if (ev.pageX) return { x : ev.pageX, y : ev.pageY};
        return {
            x : ev.clientX + el.scrollLeft - el.clientLeft,
            y : ev.clientY + el.scrollTop - el.clientTop
        };
    },
    setOpacity : function(el, opacity) {
        if (typeof el.style.opacity == "undefined") {
            el.style.filter = (opacity == 100) ? "" : "alpha(opacity=" + opacity + ")";
        } else {
            el.style.opacity = (opacity == 100) ? "" : "0." + opacity.toString();
        }
    },
    getIframeDoc : function(iframe) {
        return iframe.contentDocument || iframe.contentWindow.document;
    },
    rgbToHex : function(str) {
        function hex(s) {
            s = parseInt(s).toString(16);
            return s.length > 1 ? s : '0' + s;
        };
        return str.replace(/rgb\s*?\(\s*?(\d+)\s*?,\s*?(\d+)\s*?,\s*?(\d+)\s*?\)/ig,
                           function($0, $1, $2, $3) {
                               return '#' + hex($1) + hex($2) + hex($3);
                           }
                          );
    },
    createRange : function(doc) {
        return doc.createRange ? doc.createRange() : doc.body.createTextRange();
    },
    getNodeType : function(node) {
        return (node.nodeType == 1 && KE.util.inArray(node.tagName.toLowerCase(), KE.setting.noEndTags)) ? 88 : node.nodeType;
    },
    getNodeTextLength : function(node) {
        var type = KE.util.getNodeType(node);
        if (type == 1) {
            var html = node.innerHTML;
            return html.replace(/<.*?>/ig, "").length;
        } else if (type == 3) {
            return node.nodeValue.length;
        }
    },
    getNodeStartRange : function(doc, node) {
        var range = KE.util.createRange(doc);
        var type = node.nodeType;
        if (type == 1) {
            range.moveToElementText(node);
            return range;
        } else if (type == 3) {
            var offset = 0;
            var sibling = node.previousSibling;
            while (sibling) {
                if (sibling.nodeType == 1) {
                    var nodeRange = KE.util.createRange(doc);
                    nodeRange.moveToElementText(sibling);
                    range.setEndPoint('StartToEnd', nodeRange);
                    range.moveStart('character', offset);
                    return range;
                } else if (sibling.nodeType == 3) {
                    offset += sibling.nodeValue.length;
                }
                sibling = sibling.previousSibling;
            }
            range.moveToElementText(node.parentNode);
            range.moveStart('character', offset);
            return range;
        }
    },
    removeParent : function(parent) {
        if (parent.hasChildNodes) {
            var node = parent.firstChild;
            while (node != null) {
                var nextNode = node.nextSibling;
                parent.parentNode.insertBefore(node, parent);
                node = nextNode;
            }
        }
        parent.parentNode.removeChild(parent);
    },
    drag : function(id, mousedownObj, moveObj, func) {
        var obj = KE.g[id];
        mousedownObj.onmousedown = function(e) {
            if (KE.browser != 'IE') e.preventDefault();
            var pos = KE.util.getCoords(e);
            var objTop = parseInt(moveObj.style.top);
            var objLeft = parseInt(moveObj.style.left);
            var objWidth = moveObj.style.width;
            var objHeight = moveObj.style.height;
            if (objWidth.match(/%$/)) objWidth = moveObj.offsetWidth + 'px';
            if (objHeight.match(/%$/)) objHeight = moveObj.offsetHeight + 'px';
            objWidth = parseInt(objWidth);
            objHeight = parseInt(objHeight);
            var mouseTop = pos.y;
            var mouseLeft = pos.x;
            var dragFlag = true;
            var moveListener = function(e) {
                if (dragFlag) {
                    var pos = KE.util.getCoords(e);
                    var top = pos.y - mouseTop;
                    var left = pos.x - mouseLeft;
                    func(objTop, objLeft, objWidth, objHeight, top, left);
                }
            };
            var iframePos = KE.util.getElementPos(obj.iframe);
            var iframeMoveListener = function(e) {
                if (dragFlag) {
                    var pos = KE.util.getCoords(e, obj.iframeDoc);
                    var top = iframePos.y + pos.y - mouseTop;
                    var left = iframePos.x + pos.x - mouseLeft;
                    func(objTop, objLeft, objWidth, objHeight, top, left);
                }
            };
            var upListener = function(e) {
                dragFlag = false;
                KE.event.remove(document, 'mousemove', moveListener);
                KE.event.remove(document, 'mouseup', upListener);
                KE.event.remove(obj.iframeDoc, 'mousemove', iframeMoveListener);
                KE.event.remove(obj.iframeDoc, 'mouseup', upListener);
            };
            KE.event.add(document, 'mousemove', moveListener);
            KE.event.add(document, 'mouseup', upListener);
            KE.event.add(obj.iframeDoc, 'mousemove', iframeMoveListener);
            KE.event.add(obj.iframeDoc, 'mouseup', upListener);
        };
    },
    setDefaultPlugin : function(id) {
        var items = [
            'bold', 'italic', 'underline', 'strikethrough', 'unlink'
        ];
        for (var i = 0; i < items.length; i++) {
            KE.plugin[items[i]] = {
                click : new Function('id', 'KE.util.execCommand(id, "' + items[i] + '", null);')
            };
        }
    },
    getFullHtml : function(id, tagLineMode) {
        var html = '<html>';
        html += '<head>';
        html += '<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />';
        html += '<title>KindEditor</title>';
        if (tagLineMode) {
            html += '<link href="' + KE.g[id].skinsPath + 'editor.css" rel="stylesheet" type="text/css" />';
        }
        if (KE.g[id].cssPath) {
            html += '<link href="' + KE.g[id].cssPath + '" rel="stylesheet" type="text/css" />';
        }
        html += '</head>';
        html += '<body class="ke-content"></body>';
        html += '</html>';
        return html;
    },
    resize : function(id, width, height, isCheck, isResizeWidth) {
        isResizeWidth = (typeof isResizeWidth == "undefined") ? true : isResizeWidth;
        var obj = KE.g[id];
        if (!obj.container) return;
        if (isCheck && (parseInt(width) <= obj.minWidth || parseInt(height) <= obj.minHeight)) return;
        if (isResizeWidth) obj.container.style.width = width;
        obj.container.style.height = height;
        if (!obj.toolbarTable.offsetHeight) {
            setTimeout(function () {
                KE.util.resize(id, width, height, isCheck, isResizeWidth);
            }, 0);
            return;
        }
        var diff = parseInt(height) - obj.toolbarTable.offsetHeight - obj.bottom.offsetHeight;
        if (diff >= 0) {
            obj.textareaTable.style.height = diff + 'px';
            obj.iframe.style.height = diff + 'px';
            obj.newTextarea.style.height = diff + 'px';
        }
    },
    getData : function(id) {
        var obj = KE.g[id];
        if (!obj.wyswygMode) {
            obj.iframeDoc.body.innerHTML = obj.newTextarea.value;
        }
        if (obj.filterMode) {
            return KE.format.getHtml(obj.iframeDoc.body.innerHTML, obj.htmlTags);
        } else {
            return KE.format.getHtml(obj.iframeDoc.body.innerHTML);
        }
    },
    getSrcData : function(id) {
        var obj = KE.g[id];
        if (!obj.wyswygMode) {
            obj.iframeDoc.body.innerHTML = obj.newTextarea.value;
        }
        return obj.iframeDoc.body.innerHTML;
    },
    getPureData : function(id) {
        var data = this.getSrcData(id);
        data = data.replace(/<br[\s\/]{0,2}>/ig, "\r\n");
        data = data.replace(/<.*?>/ig, "");
        data = data.replace(/&nbsp;/ig, "");
        return data;
    },
    setData : function(id) {
        KE.g[id].srcTextarea.value = this.getData(id);
    },
    focus : function(id) {
        if (KE.g[id].wyswygMode) {
            KE.g[id].iframeWin.focus();
        } else {
            KE.g[id].newTextarea.focus();
        }
    },
    click : function(id, cmd) {
        KE.layout.hide(id);
        KE.util.focus(id);
        KE.plugin[cmd].click(id);
    },
    selection : function(id) {
        var win = KE.g[id].iframeWin;
        var doc = KE.g[id].iframeDoc;
        KE.g[id].keSel = new KE.selection(win, doc);
        KE.g[id].keRange = KE.g[id].keSel.keRange;
        KE.g[id].sel = KE.g[id].keSel.sel;
        KE.g[id].range = KE.g[id].keSel.range;
    },
    select : function(id) {
        if (KE.browser == 'IE') KE.g[id].range.select();
    },
    pToBr : function(id) {
        if(KE.browser == 'IE') {
            KE.event.add(KE.g[id].iframeDoc, 'keydown', function(e) {
                if (e.keyCode == 13) {
                    KE.util.selection(id);
                    if(KE.g[id].range.parentElement().tagName != 'LI') {
                        KE.util.insertHtml(id, '<br />');
                        KE.util.select(id);
                        return false;
                    }
                }
            });
        }
    },
    execCommand : function(id, cmd, value) {
        try {
            KE.g[id].iframeDoc.execCommand(cmd, false, value);
        } catch(e) {}
        KE.toolbar.updateState(id);
        KE.history.add(id, false);
    },
    insertHtml : function(id, html) {
        if (html == '') return;
        KE.util.select(id);
        if (KE.browser == 'IE') {
            if (KE.g[id].sel.type.toLowerCase() == 'control') {
                KE.g[id].range.item(0).outerHTML = html;
            } else {
                KE.g[id].range.pasteHTML(html);
            }
            KE.history.add(id, false);
        } else {
            this.execCommand(id, 'inserthtml', html);
        }
    }
};

KE.layout = {
    show : function(id, div) {
        KE.layout.hide(id);
        KE.g[id].hideDiv.appendChild(div);
        KE.g[id].hideDiv.style.display = 'block';
        KE.g[id].layoutDiv = div;
    },
    hide : function(id) {
        try {
            KE.g[id].hideDiv.removeChild(KE.g[id].layoutDiv);
        } catch (e) {}
        KE.g[id].hideDiv.style.display = 'none';
        KE.g[id].maskDiv.style.display = 'none';
        KE.util.focus(id);
    },
    make : function(id) {
        var div = KE.$$('div');
        div.style.position = 'absolute';
        div.style.zIndex = 19811214;
        return div;
    }
};

KE.menu = function(arg){
    this.arg = arg;
    var div = KE.layout.make(arg.id);
    div.className = 'ke-menu';
    var obj = KE.g[arg.id].toolbarIcon[arg.cmd];
    var pos = KE.util.getElementPos(obj[0]);
    div.style.top = pos.y + obj[0].offsetHeight + 'px';
    div.style.left = pos.x + 'px';
    this.div = div;
    this.add = function(html, event) {
        var cDiv = KE.$$('div');
        cDiv.className = 'ke-menu-noselected';
        cDiv.style.width = this.arg.width;
        cDiv.onmouseover = function() { this.className = 'ke-menu-selected'; }
        cDiv.onmouseout = function() { this.className = 'ke-menu-noselected'; }
        cDiv.onclick = event;
        cDiv.innerHTML = html;
        this.append(cDiv);
    };
    this.append = function(el) {
        this.div.appendChild(el);
    };
    this.insert = function(html) {
        this.div.innerHTML = html;
    };
    this.show = function() {
        KE.layout.show(this.arg.id, this.div);
    };
    this.picker = function() {
        var colorTable = KE.setting.colorTable;
        var table = KE.$$('table');
        table.cellPadding = 0;
        table.cellSpacing = 0;
        table.border = 0;
        table.style.margin = 0;
        table.style.padding = 0;
        table.style.borderCollapse = 'separate';
        table.className = 'ke-colortable';
        for (var i = 0; i < colorTable.length; i++) {
            var row = table.insertRow(i);
            for (var j = 0; j < colorTable[i].length; j++) {
                var cell = row.insertCell(j);
                cell.className = 'ke-picker-cell';
                cell.style.backgroundColor = colorTable[i][j];
                cell.title = colorTable[i][j];
                cell.onmouseover = function() {this.style.borderColor = '#000000';this.style.borderWidth = '1px'; }
                cell.onmouseout = function() {this.style.borderColor = '#F0F0EE';this.style.borderWidth = '2px'; }
                cell.onclick = new Function('KE.plugin["' + this.arg.cmd + '"].exec("' +
                                            this.arg.id + '", "' + colorTable[i][j] + '")');
                cell.innerHTML = '&nbsp;';
            }
        }
        this.append(table);
        this.show();
    };
};

KE.dialog = function(arg){
    this.arg = arg;
    this.topHeight = 20;
    this.bottomHeight = 76;
    this.getPos = function() {
        var arg = this.arg;
        var id = this.arg.id;
        var obj = KE.g[id];
        var pos = KE.util.getElementPos(KE.g[id].container);
        var height = arg.height + this.topHeight + this.bottomHeight;
        var w = obj.container.style.width;
        var h = obj.container.style.height;
        if (w.match(/%$/)) w = obj.container.offsetWidth + 'px';
        if (h.match(/%$/)) h = obj.container.offsetHeight + 'px';
        var xDiff = Math.round(parseInt(w) / 2) - Math.round(arg.width / 2);
        var yDiff = Math.round(parseInt(h) / 2) - Math.round(height / 2);
        var x = xDiff < 0 ? pos.x : pos.x + xDiff;
        var y = yDiff < 0 ? pos.y : pos.y + yDiff;
        return {'x' : x, 'y' : y};
    };
    this.show = function() {
        var arg = this.arg;
        var id = arg.id;
        var div = KE.layout.make(arg.id);
        div.className = 'ke-dialog';
        var pos = this.getPos();
        div.style.width = (arg.width + this.topHeight) + 'px';
        div.style.height = (arg.height + this.bottomHeight) + 'px';
        div.style.top = pos.y + 'px';
        div.style.left = pos.x + 'px';
        var titleDiv = KE.$$('div');
        titleDiv.className = 'ke-dialog-title';
        titleDiv.innerHTML = arg.title;
        var span = KE.$$('span');
        var url = KE.g[id].skinsPath + KE.g[id].skinType + '.gif';
        span.style.backgroundImage = "url(" + url + ")";
        span.className = "ke-toolbar-close";
        span.alt = KE.lang['close'];
        span.title = KE.lang['close'];
        span.onclick = new Function("KE.layout.hide('" + id + "')");
        titleDiv.appendChild(span);
        KE.util.drag(id, titleDiv, div, function(objTop, objLeft, objWidth, objHeight, top, left) {
            div.style.top = (objTop + top) + 'px';
            div.style.left = (objLeft + left) + 'px';
        });
        div.appendChild(titleDiv);
        var bodyDiv = KE.$$('div');
        bodyDiv.className = 'ke-dialog-body';
        var dialog = KE.$$('iframe');
        if (arg.useFrameCSS) {
            dialog.className = 'ke-dialog-iframe';
        }
        dialog.width = arg.width + 10 + 'px';
        dialog.height = arg.height + 10 + 'px';
        dialog.setAttribute("frameBorder", "0");
        bodyDiv.appendChild(dialog);
        div.appendChild(bodyDiv);

        var bottomDiv = KE.$$('div');
        bottomDiv.className = 'ke-dialog-bottom';
        var noButton = null;
        var yesButton = null;
        var previewButton = null;
        if (arg.previewButton) {
            previewButton = KE.$$('input');
            previewButton.className = 'nav-blue2-but';
            previewButton.style.marginRight="4px";
            
            previewButton.type = 'button';
            previewButton.name = 'previewButton';
            previewButton.value = arg.previewButton;
            previewButton.onclick = new Function("KE.plugin['" + arg.cmd  + "'].preview('" + id + "')");
            bottomDiv.appendChild(previewButton);
        }
        if (arg.yesButton) {
            yesButton = KE.$$('input');
            yesButton.className = 'nav-blue2-but';
            yesButton.type = 'button';
            yesButton.name = 'yesButton';
            yesButton.value = arg.yesButton;
            yesButton.onclick = new Function("KE.plugin['" + arg.cmd  + "'].exec('" + id + "');");
            bottomDiv.appendChild(yesButton);
        }
        if (arg.noButton) {
            noButton = KE.$$('input');
            noButton.className = 'nav-blue2-but';
            noButton.type = 'button';
            noButton.name = 'noButton';
            noButton.style.marginLeft="4px";
            noButton.style.marginRight="15px";
            noButton.value = arg.noButton;
            noButton.onclick = new Function("KE.layout.hide('" + id + "')");
            bottomDiv.appendChild(noButton);
        }

        div.appendChild(bottomDiv);
        KE.layout.show(id, div);
        window.focus();
        if (yesButton) yesButton.focus();
        else if (noButton) noButton.focus();
        if (typeof arg.html != "undefined") {
            var dialogDoc = KE.util.getIframeDoc(dialog);
            var html = KE.util.getFullHtml(id, false);
            dialogDoc.open();
            dialogDoc.write(html);
            dialogDoc.close();
            dialogDoc.body.innerHTML = arg.html;
        } else {
			if (typeof arg.file == "undefined") {
				dialog.src = KE.g[id].pluginsPath + arg.cmd + '.html?ver=' + KE.version;
			} else {
				if(arg.file.indexOf(domain)!=-1 
					|| arg.file.indexOf("http://")!=-1 
					|| arg.file.indexOf("https://")!=-1 ){
					dialog.src = arg.file;
				}else{
					dialog.src = KE.g[id].pluginsPath + arg.file;
				}
			}
        }
        KE.g[id].maskDiv.style.width = KE.util.getDocumentWidth() + 'px';
        KE.g[id].maskDiv.style.height = KE.util.getDocumentHeight() + 'px';
        KE.g[id].maskDiv.style.display = 'block';
        KE.g[id].dialog = dialog;
        KE.g[id].noButton = noButton;
        KE.g[id].yesButton = yesButton;
        KE.g[id].previewButton = previewButton;
        
        //屏蔽F5
        KE.util.getIframeDoc(dialog).onkeydown = function(){
	    	var e = dialog.contentWindow.event;
			if(e.keyCode==116){e.keyCode=0;e.returnValue=false;}
	    }
    };
};

KE.toolbar = {
    updateState : function(id) {
        var cmdList = [
            'bold', 'italic', 'underline', 'strikethrough'
        ];
        for (var i = 0; i < cmdList.length; i++) {
            var cmd = cmdList[i];
            var state = false;
            try {
                state = KE.g[id].iframeDoc.queryCommandState(cmd);
            } catch(e) {}
            if (state) {
                KE.toolbar.select(id, cmd);
            } else {
                KE.toolbar.unselect(id, cmd);
            }
        }
    },
    isSelected : function(id, cmd) {
        if (KE.plugin[cmd] && KE.plugin[cmd].isSelected) return true;
        else return false;
    },
    select : function(id, cmd) {
        if (KE.g[id].toolbarIcon[cmd]) {
            var a = KE.g[id].toolbarIcon[cmd][0];
            a.className = "ke-icon-selected";
            a.onmouseover = null;
            a.onmouseout = null;
        }
    },
    unselect : function(id, cmd) {
        if (KE.g[id].toolbarIcon[cmd]) {
            var a = KE.g[id].toolbarIcon[cmd][0];
            a.className = "ke-icon";
            a.onmouseover = function(){ this.className = "ke-icon-on"; };
            a.onmouseout = function(){ this.className = "ke-icon"; };
        }
    },
    able : function(id, arr) {
        KE.each(KE.g[id].toolbarIcon, function(cmd, obj) {
            if (!KE.util.inArray(cmd, arr)) {
                var a = obj[0];
                var span = obj[1];
                a.className = 'ke-icon';
                KE.util.setOpacity(span, 100);
                a.onclick = new Function('KE.util.click("' + id + '", "' + cmd + '");');
                a.onmouseover = function(){ this.className = "ke-icon-on"; };
                a.onmouseout = function(){ this.className = "ke-icon"; };
            }
        });
    },
    disable : function(id, arr) {
        KE.each(KE.g[id].toolbarIcon, function(cmd, obj) {
            if (!KE.util.inArray(cmd, arr)) {
                var a = obj[0];
                var span = obj[1];
                a.className = 'ke-icon-disabled';
                KE.util.setOpacity(span, 50);
                a.onclick = null;
                a.onmouseover = null;
                a.onmouseout = null;
            }
        });
    },
    create : function(id) {
        KE.g[id].toolbarIcon = [];
        var tableObj = KE.util.createTable();
        var toolbar = tableObj.table;
        toolbar.className = 'ke-toolbar';
        toolbar.oncontextmenu = function() { return false; };
        toolbar.onmousedown = function() { return false; };
        toolbar.onmousemove = function() { return false; };
        var toolbarCell = tableObj.cell;
        var length = KE.g[id].items.length;
        var cellNum = 0;
        var row;
        for (var i = 0; i < length; i++) {
            var cmd = KE.g[id].items[i];
            if (i == 0 || cmd == '-') {
                var table = KE.util.createMyfun7Table().table;
                table.className = 'ke-toolbar-table';
                row = table.insertRow(0);
                cellNum = 0;
                toolbarCell.appendChild(table);
                if (cmd == '-') continue;
            }
            var cell = row.insertCell(cellNum);
            cell.hideforcus = true;
            cellNum++;
            var a = KE.$$('a');
            a.className = 'ke-icon';
            a.href = 'javascript:;';
            a.onclick = new Function('KE.util.click("' + id + '", "' + cmd + '");');
            a.onmouseover = function(){ this.className = "ke-icon-on"; };
            a.onmouseout = function(){ this.className = "ke-icon"; };
            a.hidefocus = true;
            a.title = KE.lang[cmd];
            var span = KE.$$('span');
            span.className = "ke-common-icon ke-icon-" + cmd;
            if (KE.util.inArray(cmd, KE.g[id].defaultItems)) {
                var url = KE.g[id].skinsPath + KE.g[id].skinType + '.gif';
                span.style.backgroundImage = "url(" + url + ")";
            }
            a.appendChild(span);
            cell.appendChild(a);
            KE.g[id].toolbarIcon[cmd] = [a, span];
            if (KE.toolbar.isSelected(id, cmd)) KE.toolbar.select(id, cmd);
        }
        return toolbar;
    }
};

KE.history = {
    add : function(id, minChangeFlag) {
        var obj = KE.g[id];
        var html = KE.util.getSrcData(id);
        if (obj.undoStack.length > 0) {
            var prevHtml = obj.undoStack[obj.undoStack.length - 1];
            if (html == prevHtml) return;
            if (minChangeFlag && Math.abs(html.length - prevHtml.length) < obj.minChangeSize) return;
        }
        obj.undoStack.push(html);
        obj.redoStack = [];
    },
    undo : function(id) {
        var obj = KE.g[id];
        if (obj.undoStack.length == 0) return;
        var html = KE.util.getSrcData(id);
        obj.redoStack.push(html);
        var prevHtml = obj.undoStack.pop();
        if (html == prevHtml && obj.undoStack.length > 0) {
            prevHtml = obj.undoStack.pop();
        }
        obj.iframeDoc.body.innerHTML = prevHtml;
        obj.newTextarea.value = prevHtml;
    },
    redo : function(id) {
        var obj = KE.g[id];
        if (obj.redoStack.length == 0) return;
        var html = KE.util.getSrcData(id);
        obj.undoStack.push(html);
        var nextHtml = obj.redoStack.pop();
        obj.iframeDoc.body.innerHTML = nextHtml;
        obj.newTextarea.value = nextHtml;
    }
};

KE.remove = function(id, mode) {
    if (!KE.g[id].container) return false;
    mode = (typeof mode == "undefined") ? 0 : mode;
    var container = KE.g[id].container;
    if (mode == 1) {
        document.body.removeChild(container);
    } else {
        var srcTextarea = KE.g[id].srcTextarea;
        srcTextarea.parentNode.removeChild(container);
        if (mode == 0) srcTextarea.style.display = '';
    }
    document.body.removeChild(KE.g[id].hideDiv);
    document.body.removeChild(KE.g[id].maskDiv);
    KE.g[id].container = null;
};

KE.create = function(id, mode) {
	
    if (KE.browser == 'IE') try { document.execCommand('BackgroundImageCache', false, true); }catch(e){}
    var srcTextarea = KE.$(id);
    mode = (typeof mode == "undefined") ? 0 : mode;
    if (mode == 0 && KE.g[id].container) return;
    var width = KE.g[id].width || srcTextarea.style.width || srcTextarea.offsetWidth + 'px';
    var height = KE.g[id].height || srcTextarea.style.height || srcTextarea.offsetHeight + 'px';
    var tableObj = KE.util.createTable();
    var container = tableObj.table;
    container.className = 'ke-container';
    container.style.width = width;
    container.style.height = height;
    var toolbarOuter = tableObj.cell;
    toolbarOuter.className = 'ke-toolbar-outer';
    var textareaOuter = container.insertRow(1).insertCell(0);
    textareaOuter.className = 'ke-textarea-outer';
    tableObj = KE.util.createTable();
    var textareaTable = tableObj.table;
    textareaTable.className = 'ke-textarea-table';
    var textareaCell = tableObj.cell;
    textareaOuter.appendChild(textareaTable);
    var bottomOuter = container.insertRow(2).insertCell(0);
    bottomOuter.className = 'ke-bottom-outer';
    if (mode == 1) document.body.appendChild(container);
    else srcTextarea.parentNode.insertBefore(container, srcTextarea);
    var toolbarTable = KE.toolbar.create(id);
    toolbarOuter.appendChild(toolbarTable);
    var iframe = KE.$$('iframe');
    iframe.className = 'ke-iframe';
    iframe.setAttribute("frameBorder", "0");
    var newTextarea = KE.$$('textarea');
    newTextarea.className = 'ke-textarea';
    newTextarea.style.display = 'none';
    textareaCell.appendChild(iframe);
    textareaCell.appendChild(newTextarea);
    var bottom = KE.$$('table');
    bottom.className = 'ke-bottom';
    bottom.cellPadding = 0;
    bottom.cellSpacing = 0;
    bottom.border = 0;
    var row = bottom.insertRow(0);
    var bottomLeft = row.insertCell(0);
    //bottomLeft.className = 'ke-bottom-left';
    var bottomRight = row.insertCell(1);
    //bottomRight.className = 'ke-bottom-right';
    //var span = KE.$$('span');
    //var url = KE.g[id].skinsPath + KE.g[id].skinType + '.gif';
    //span.style.backgroundImage = "url(" + url + ")";
    //span.className = 'ke-bottom-right-img';
    //bottomRight.appendChild(span);
    bottomOuter.appendChild(bottom);
    var hideDiv = KE.$$('div');
    hideDiv.style.display = 'none';
    var maskDiv = KE.$$('div');
    maskDiv.className = 'ke-mask';
    KE.util.setOpacity(maskDiv, 50);
    document.body.appendChild(hideDiv);
    document.body.appendChild(maskDiv);
    srcTextarea.style.display = "none";
    KE.util.setDefaultPlugin(id);
    var iframeWin = iframe.contentWindow;
    var iframeDoc = KE.util.getIframeDoc(iframe);
    iframeDoc.designMode = "On";
    var html = KE.util.getFullHtml(id, KE.g[id].tagLineMode);
    iframeDoc.open();
    iframeDoc.write(html);
    iframeDoc.body.oncontextmenu=function(){return false;};
    iframeDoc.body.contentEditable="True";
    iframeDoc.close();
    iframeDoc.onkeydown = function(){
    	var e = iframeWin.event;
		if(e.keyCode==116){e.keyCode=0;e.returnValue=false;}
    }
    if (!KE.g[id].wyswygMode) {
        newTextarea.value = srcTextarea.value;
        newTextarea.style.display = 'block';
        iframe.style.display = 'none';
        KE.toolbar.disable(id, ['source', 'preview', 'fullscreen']);
        KE.toolbar.select(id, 'source');
    }
    if (KE.g[id].autoOnsubmitMode) {
        var form = srcTextarea.parentNode;
        while (form != null && form.tagName != 'FORM') { form = form.parentNode; }
        if (form != null && form.tagName == 'FORM') {
            KE.event.add(form, 'submit', new Function('KE.util.setData("' + id + '")'));
        }
    }
    KE.event.add(iframeDoc, 'click', new Function('KE.layout.hide("' + id + '")'));
    KE.event.add(iframeDoc, 'click', new Function('KE.toolbar.updateState("' + id + '")'));
    KE.event.input(iframeDoc, new Function('KE.history.add("' + id + '", true)'));
    KE.event.input(iframeDoc, new Function('KE.toolbar.updateState("' + id + '")'));
    KE.event.add(newTextarea, 'click', new Function('KE.layout.hide("' + id + '")'));
    KE.event.input(newTextarea, new Function('KE.history.add("' + id + '", true)'));
    KE.event.add(iframeDoc, 'keydown', function(e) {
        if (e.keyCode == 9) {
            KE.util.selection(id);
            KE.util.insertHtml(id, '　　');
            KE.util.select(id);
            if (e.preventDefault) e.preventDefault();
            if (e.stopPropagation) e.stopPropagation();
            return false;
        }
    });
    KE.g[id].container = container;
    KE.g[id].toolbarTable = toolbarTable;
    KE.g[id].textareaTable = textareaTable;
    KE.g[id].iframe = iframe;
    KE.g[id].newTextarea = newTextarea;
    KE.g[id].srcTextarea = srcTextarea;
    KE.g[id].bottom = bottom;
    KE.g[id].hideDiv = hideDiv;
    KE.g[id].maskDiv = maskDiv;
    KE.g[id].iframeWin = iframeWin;
    KE.g[id].iframeDoc = iframeDoc;
    KE.g[id].width = width;
    KE.g[id].height = height;
    KE.util.resize(id, width, height);
    if (KE.g[id].resizeMode > 0) {
        KE.util.drag(id, bottomRight, container, function(objTop, objLeft, objWidth, objHeight, top, left) {
            if (KE.g[id].resizeMode == 2) KE.util.resize(id, (objWidth + left) + 'px', (objHeight + top) + 'px', true);
            else if (KE.g[id].resizeMode == 1) KE.util.resize(id, objWidth + 'px', (objHeight + top) + 'px', true, false);
        });
        KE.util.drag(id, bottomLeft, container, function(objTop, objLeft, objWidth, objHeight, top, left) {
            if (KE.g[id].resizeMode > 0) KE.util.resize(id, objWidth + 'px', (objHeight + top) + 'px', true, false);
        });
    }
    for (var i = 0, len = KE.g[id].items.length; i < len; i++) {
        var cmd = KE.g[id].items[i];
        if (KE.plugin[cmd] && KE.plugin[cmd].init) KE.plugin[cmd].init(id);
    }
    if (srcTextarea.value !== "") iframeDoc.body.innerHTML = srcTextarea.value;
    KE.history.add(id, false);
    window.focus();
};

KE.init = function(config) {
    config.wyswygMode = (typeof config.wyswygMode == "undefined") ? KE.setting.wyswygMode : config.wyswygMode;
    config.autoOnsubmitMode = (typeof config.autoOnsubmitMode == "undefined") ? KE.setting.autoOnsubmitMode : config.autoOnsubmitMode;
    config.resizeMode = (typeof config.resizeMode == "undefined") ? KE.setting.resizeMode : config.resizeMode;
    config.filterMode = (typeof config.filterMode == "undefined") ? KE.setting.filterMode : config.filterMode;
    config.tagLineMode = (typeof config.tagLineMode == "undefined") ? KE.setting.tagLineMode : config.tagLineMode;
    config.skinType = config.skinType || KE.setting.skinType;
    config.cssPath = config.cssPath || KE.setting.cssPath;
    config.skinsPath = config.skinsPath || KE.setting.skinsPath;
    config.pluginsPath = config.pluginsPath || KE.setting.pluginsPath;
    config.minWidth = config.minWidth || KE.setting.minWidth;
    config.minHeight = config.minHeight || KE.setting.minHeight;
    config.minChangeSize = config.minChangeSize || KE.setting.minChangeSize;
    config.defaultItems = KE.setting.items;
    config.items = config.items || KE.setting.items;
    config.htmlTags = config.htmlTags || KE.setting.htmlTags;
    KE_ID = config.id;
    KE.g[config.id] = config;
    KE.g[config.id].undoStack = [];
    KE.g[config.id].redoStack = [];
    KE.util.loadStyle(config.skinsPath + config.skinType + '.css');
    //设置图片服务器的路径
    config.imgServerUrl = (typeof config.imgServerUrl == "undefined") ? KE.setting.imgServerUrl : config.imgServerUrl;
}

KE.getID = function(){
	return KE_ID;
};

KE.show = function(config) {
    KE.init(config);
    KE.event.ready(new Function('KE.create("' + config.id + '")'));
};
KE.plugin['undo'] = {
    init : function(id) {
        KE.event.ctrl(KE.g[id].iframeDoc, 'Z', function(e) {
            KE.plugin['undo'].click(id);
            KE.util.focus(id);
        });
    },
    click : function(id) {
        KE.history.undo(id);
    }
};

KE.plugin['redo'] = {
    init : function(id) {
        KE.event.ctrl(KE.g[id].iframeDoc, 'Y', function(e) {
            KE.plugin['redo'].click(id);
            KE.util.focus(id);
        });
    },
    click : function(id) {
        KE.history.redo(id);
    }
};

KE.plugin['fullscreen'] = {
    click : function(id) {
        var obj = KE.g[id];
        var self = this;
        var resetSize = function() {
            var el = KE.util.getDocumentElement();
            obj.width = el.clientWidth + 'px';
            obj.height = (el.clientHeight-8) + 'px';
        };
        var windowSize = '';
        var resizeListener = function() {
            if (!self.isSelected) return;
            var el = KE.util.getDocumentElement();
            var size = [el.clientWidth, el.clientHeight].join('');
            if (windowSize != size) {
                windowSize = size;
                resetSize();
                KE.util.resize(id, obj.width, obj.height);
            }
        };
        var showScroll = function(type){
        	document.getElementsByTagName("html")[0].style.overflowY = type;
        	window.scrollTo(0,99999);
        };
        if (this.isSelected) {
            this.isSelected = false;
            KE.util.setData(id);
            KE.remove(id, 1);
            obj.width = this.width;
            obj.height = this.height;
            KE.create(id, 2);
            showScroll('auto');
            KE.event.remove(window, 'resize', resizeListener);
            KE.toolbar.unselect(id, "fullscreen");
        } else {
            this.isSelected = true;
            KE.util.setData(id);
            this.width = obj.container.style.width;
            this.height = obj.container.style.height;
            KE.remove(id, 2);
            showScroll('hidden');
            resetSize();
            KE.create(id, 1);
            var left,top;
            if (KE.browser == 'IE' || KE.browser == 'OPERA') {
                left = document.documentElement.scrollLeft;
                top = document.documentElement.scrollTop;
            } else {
                left = window.scrollX;
                top = window.scrollY;
            }
            var div = KE.g[id].container;
            div.style.position = 'absolute';
            div.style.left = left + 'px';
            div.style.top = top + 'px';
            div.style.zIndex = 19811211;
            KE.event.add(window, 'resize', resizeListener);
            KE.toolbar.select(id, "fullscreen");
        }
    }
};

KE.plugin['hr'] = {
    click : function(id) {
        KE.util.selection(id);
        KE.util.insertHtml(id, '<hr />');
        KE.util.focus(id);
    }
};

KE.plugin['preview'] = {
    click : function(id) {
        var dialog = new KE.dialog({
            id : id,
            cmd : 'preview',
            html : KE.util.getData(id),
            width : 600,
            height : 400,
            useFrameCSS : true,
            title : KE.lang['preview'],
            noButton : KE.lang['close']
        });
        dialog.show();
    }
};

KE.plugin['emoticons'] = {
    icon : 'emoticons.gif',
    click : function(id) {
		var dom;
		var oNodes;
		xmlFile = KE.g[id].pluginsPath + "emotions2/EmotionConfig.xml"
		if(window.ActiveXObject){	//IE
			dom = new ActiveXObject("Microsoft.XMLDOM");
			dom.async = false;
			dom.load(xmlFile);
			oNodes = dom.documentElement.childNodes;
		}else{	//FF
			dom = document.implementation.createDocument("", "", null);
			dom.async = false;
			dom.load(xmlFile);
			oNodes = dom.getElementsByTagName("Item");
		}
        items = oNodes.length;
        
        filePath = "emotions2/";//表情头像的根路径
        var cmd = 'emoticons';//这个保持不变的。
        KE.util.selection(id);
        var table = KE.$$('table');
        table.cellPadding = 0;
        table.cellSpacing = 2;
        table.border = 0;
        table.style.borderColor = "#DFE6F6";
        table.style.borderWidth = "1px";
        table.style.margin = 0;
        table.style.padding = 0;
        table.style.borderCollapse = 'separate';
        table.style.borderSpacing = '2px';
        var row;
        for (var i = 0; i < items; i++) {
            var j = parseInt(i%15);
            var rowIndex = parseInt(i/15);
            if(j==0){
            	row = table.insertRow(rowIndex);
            }
            var cell = row.insertCell(j);
            //当图片链接为空时，过滤掉，不设置相应属性			if(window.ActiveXObject){	//IE
	            ShortCut = oNodes[i].childNodes[0].text;
	            Meaning = oNodes[i].childNodes[1].text;
	            OriginalFile = oNodes[i].childNodes[2].text;
	            FixedFile = oNodes[i].childNodes[3].text;
			}else{
	            ShortCut = oNodes[i].childNodes[1].textContent;
	            Meaning = oNodes[i].childNodes[3].textContent;
	            OriginalFile = oNodes[i].childNodes[5].textContent;
	            FixedFile = oNodes[i].childNodes[7].textContent;
			}
			
            cell.style.margin = 0;
            cell.style.padding = '1px';
            cell.style.border = '1px solid #ffffff';
            cell.style.cursor = 'pointer';
            cell.onmouseover = function() {this.style.borderColor = '#000000'; }
            cell.onmouseout = function() {this.style.borderColor = '#ffffff'; }
            cell.onclick = new Function('KE.plugin["' + cmd + '"].exec("' + id + '", "' + OriginalFile + '")');
        	var span = KE.$$('span');
			span.className = 'ke-plugin-emoticons-span';
			span.style.backgroundPosition = '-' + (24 * i) + 'px 0px';
            span.title = Meaning;
			cell.appendChild(span);
        }
        var menu = new KE.menu({
            id : id,
            cmd : cmd
        });
        menu.append(table);
        menu.show();
    },
    click2 : function(id) {
        var emoticonTable0 = [
            ['etc_01.gif','etc_02.gif','etc_03.gif','etc_04.gif','etc_05.gif','etc_06.gif'],
            ['etc_07.gif','etc_08.gif','etc_09.gif','etc_10.gif','etc_11.gif','etc_12.gif'],
            ['etc_13.gif','etc_14.gif','etc_15.gif','etc_16.gif','etc_17.gif','etc_18.gif'],
            ['etc_19.gif','etc_20.gif','etc_21.gif','etc_22.gif','etc_23.gif','etc_24.gif'],
            ['etc_25.gif','etc_26.gif','etc_27.gif','etc_28.gif','etc_29.gif','etc_30.gif'],
            ['etc_31.gif','etc_32.gif','etc_33.gif','etc_34.gif','etc_35.gif','etc_36.gif']
        ];
        var emoticonTable1 = [
            ['etc_1.gif', 'etc_2.gif','etc_3.gif','etc_4.gif','etc_5.gif','etc_6.gif','etc_7.gif','etc_8.gif','etc_9.gif','etc_10.gif'],
            ['etc_11.gif', 'etc_12.gif','etc_13.gif','etc_14.gif','etc_15.gif','etc_16.gif','etc_17.gif','etc_18.gif','etc_19.gif','etc_20.gif'],
            ['etc_21.gif', 'etc_22.gif','etc_23.gif','etc_24.gif','etc_25.gif','etc_26.gif','etc_27.gif','etc_28.gif','etc_29.gif','etc_30.gif'],
            ['etc_31.gif', 'etc_32.gif','etc_33.gif','etc_34.gif','etc_35.gif','etc_36.gif','etc_37.gif','etc_38.gif','etc_39.gif','etc_40.gif'],
            ['etc_41.gif', 'etc_42.gif','etc_43.gif','etc_44.gif','etc_45.gif','etc_46.gif','etc_47.gif','etc_48.gif','etc_49.gif','etc_50.gif'],
            ['etc_51.gif', 'etc_52.gif','etc_53.gif','etc_54.gif','etc_55.gif','etc_56.gif','etc_57.gif','etc_58.gif','etc_59.gif','etc_60.gif'],
            ['etc_61.gif', 'etc_62.gif','etc_63.gif','etc_64.gif','etc_65.gif','etc_66.gif','etc_67.gif','etc_68.gif','etc_69.gif','etc_70.gif'],
            ['etc_71.gif', 'etc_72.gif','etc_73.gif','etc_74.gif','etc_75.gif','etc_76.gif','etc_77.gif','etc_78.gif','etc_79.gif','etc_80.gif'],
            ['etc_81.gif', 'etc_82.gif','etc_83.gif','etc_84.gif','etc_85.gif','etc_86.gif','etc_87.gif','','','']
        ];
        emoticonTable = emoticonTable1;
        filePath = "emotions1/";
        var cmd = 'emoticons';
        KE.util.selection(id);
        var table = KE.$$('table');
        table.cellPadding = 0;
        table.cellSpacing = 2;
        table.border = 0;
        table.style.borderColor = "#DFE6F6";
        table.style.borderWidth = "1px";
        table.style.margin = 0;
        table.style.padding = 0;
        table.style.borderCollapse = 'separate';
        table.style.borderSpacing = '2px';
        for (var i = 0; i < emoticonTable.length; i++) {
            var row = table.insertRow(i);
            for (var j = 0; j < emoticonTable[i].length; j++) {
                var cell = row.insertCell(j);
                //当图片链接为空时，过滤掉，不设置相应属性
                if(emoticonTable[i][j]!=""){
	                cell.style.margin = 0;
	                cell.style.padding = '1px';
	                cell.style.border = '1px solid #ffffff';
	                cell.style.cursor = 'pointer';
	                cell.onmouseover = function() {this.style.borderColor = '#000000'; }
	                cell.onmouseout = function() {this.style.borderColor = '#ffffff'; }
	                cell.onclick = new Function('KE.plugin["' + cmd + '"].exec("' + id + '", "' + emoticonTable[i][j] + '")');
	                var img = KE.$$('img');
	                img.src = KE.g[id].pluginsPath + filePath + emoticonTable[i][j];
	                cell.appendChild(img);
                }
            }
        }
        var menu = new KE.menu({
            id : id,
            cmd : cmd
        });
        menu.append(table);
        menu.show();
    },
    exec : function(id, value) {
        KE.util.select(id);
        var html = '<img src="' + KE.g[id].pluginsPath + filePath + value + '" border="0" />';
        KE.util.insertHtml(id, html);
        KE.layout.hide(id);
        KE.util.focus(id);
    }
};

KE.plugin['flash'] = {
    click : function(id) {
        KE.util.selection(id);
        var dialog = new KE.dialog({
            id : id,
            cmd : 'flash',
            width : 280,
            height : 250,
            title : "Flash",
            previewButton : KE.lang['preview'],
            yesButton : KE.lang['yes'],
            noButton : KE.lang['no']
        });
        dialog.show();
    },
    check : function(id, url) {
        if (url.match(/\w+:\/\/.{3,}/) == null) {
            alert(KE.lang['invalidUrl']);
            window.focus();
            KE.g[id].yesButton.focus();
            return false;
        }
        return true;
    },
    preview : function(id) {
        var dialogDoc = KE.util.getIframeDoc(KE.g[id].dialog);
        var url = KE.$('url', dialogDoc).value;
        if (!this.check(id, url)) return false;
        var embed = KE.$$('embed', dialogDoc);
        embed.src = url;
        embed.type = "application/x-shockwave-flash";
        embed.quality = "high";
        embed.width = 260;
        embed.height = 190;
        KE.$('previewDiv', dialogDoc).innerHTML = "";
        KE.$('previewDiv', dialogDoc).appendChild(embed);
    },
    exec : function(id) {
        KE.util.select(id);
        var dialogDoc = KE.util.getIframeDoc(KE.g[id].dialog);
        var url = KE.$('url', dialogDoc).value;
        if (!this.check(id, url)) return false;
        var html = '<embed src="' + url + '" type="application/x-shockwave-flash" quality="high" width="480" height="385"/>&nbsp;<br/>';
        KE.util.insertHtml(id, html);
        KE.layout.hide(id);
        KE.util.focus(id);
    }
};

KE.plugin['image'] = {
    click : function(id) {
        KE.util.selection(id);
        var dialog = new KE.dialog({
            id : id,
            cmd : 'image',
            width : 310,
            height : 90,
            title : KE.lang['image'],
            yesButton : KE.lang['yes'],
            noButton : KE.lang['no']
        });
        dialog.show();
    },
    check : function(id) {
        var dialogDoc = KE.util.getIframeDoc(KE.g[id].dialog);
        var type = KE.$('type', dialogDoc).value;
        var url = '';
        if (type == 1) {
            url = KE.$('imgFile', dialogDoc).value;
        } else {
            url = KE.$('url', dialogDoc).value;
        }
        if (!url.match(/\.(jpg|jpeg|gif|bmp|png)(\s|$)/i)) {
            alert(KE.lang['invalidImg']);
            window.focus();
            KE.g[id].yesButton.focus();
            return false;
        }
        return true;
    },
    exec : function(id) {
        KE.util.select(id);
        var dialogDoc = KE.util.getIframeDoc(KE.g[id].dialog);
        var type = KE.$('type', dialogDoc).value;
        if (!this.check(id)) return false;
        if (type == 1) {
            KE.$('editorId', dialogDoc).value = id;
            var imgTitle = KE.$('imgTitle', dialogDoc).value;
            KE.$('loading', dialogDoc).style.display = "";
            dialogDoc.uploadForm.action = dialogDoc.uploadForm.action + "?imgTitle="+imgTitle;
            dialogDoc.uploadForm.submit();
            return false;
        } else {
            var url = KE.$('url', dialogDoc).value;
            var title = KE.$('imgTitle', dialogDoc).value;
            this.insertRemote(id, url, title);
        }
    },
    insert : function(id, url, title, sizeStr) {
        var html = '<img src="' + url + '" ';
        var arrayObj;
        if(sizeStr && sizeStr!=""){
        	arrayObj = sizeStr.split(":");
        }
        if(arrayObj.length==2){
	        var newWidth = arrayObj[0];
	        var newHeight = arrayObj[1];
	        html += 'width="' + newWidth + '" ';
	        html += 'height="' + newHeight + '" ';
	        html += 'class="HOUSE_IMG"';
	        //if (title) html += 'title="' + title + '" alt="' + title + '" ';
	        html += '/><br/>';
	        KE.util.insertHtml(id, html);
	        KE.layout.hide(id);
	        KE.util.focus(id);
        }
    },
    insertRemote : function(id, url, title) {
        var html = '<img src="' + url + '" ';
        if (title) html += 'title="' + title + '" ';
        var arrayObj = this.getNewSize(url);
        width = arrayObj[0];
        if (width>0) html += 'width="' + width + '" ';
        html += '/>';
        KE.util.insertHtml(id, html);
        KE.layout.hide(id);
        KE.util.focus(id);
    },
    getNewSize:function (imageURL) {
		self_width = 585;//限定图片的宽度为585
		var image = new Image();
		image.src = imageURL;  //进行路径赋值，可以重新加载图片文件，获取其原始大小
		var arrayObj = new Array(2);
		if (image.width > self_width) {
			arrayObj[0] = self_width;
			arrayObj[1] = (image.height * self_width) / image.width;
		}else{
			arrayObj[0] = image.width;
			arrayObj[1] = image.height;
		}
		//alert(arrayObj[0]+":::"+arrayObj[1]);
		return arrayObj;
	}
};

KE.plugin['link'] = {
    click : function(id) {
        KE.util.selection(id);
        var dialog = new KE.dialog({
            id : id,
            cmd : 'link',
            width : 310,
            height : 70,
            title : KE.lang['link'],
            yesButton : KE.lang['yes'],
            noButton : KE.lang['no']
        });
        dialog.show();
    },
    exec : function(id) {
        KE.util.select(id);
        var iframeDoc = KE.g[id].iframeDoc;
        var range = KE.g[id].range;
        var dialogDoc = KE.util.getIframeDoc(KE.g[id].dialog);
        var url = KE.$('hyperLink', dialogDoc).value;
        var target = KE.$('linkType', dialogDoc).value;
        if (url.match(/\w+:\/\/.{3,}/) == null) {
            alert(KE.lang['invalidUrl']);
            window.focus();
            KE.g[id].yesButton.focus();
            return false;
        }
        var node;
        if (KE.browser == 'IE') {
            node = range.item ? range.item(0).parentNode : iframeDoc.body;
        } else {
            node = (range.startContainer == range.endContainer) ? range.startContainer.parentNode : iframeDoc.body;
        }
        if (node && node.tagName == 'A') node = node.parentNode;
        if (!node) node = iframeDoc.body;
        iframeDoc.execCommand("createlink", false, "__ke_temp_url__");
        var arr = node.getElementsByTagName('a');
        for (var i = 0, l = arr.length; i < l; i++) {
            if (arr[i].href.match(/\/?__ke_temp_url__$/) != null) {
                arr[i].href = url;
                if (target) arr[i].target = target;
            }
        }
        KE.history.add(id);
        KE.layout.hide(id);
        KE.util.focus(id);
    }
};

KE.plugin['about'] = {
    click : function(id) {
        var dialog = new KE.dialog({
            id : id,
            cmd : 'about',
            file : 'about.html?id=' + id + '&ver=' + KE.version,
            width : 300,
            height : 100,
            title : KE.lang['about'],
            noButton : KE.lang['close']
        });
        dialog.show();
    }
};

KE.plugin['insertHouseInfo'] = {
    click : function(id) {
    	KE.util.selection(id);
        var dialog = new KE.dialog({
            id : id,
            cmd : 'insertHouseInfo',
            file :(insertHouseInfoPath.indexOf("?")!=-1)
            	?insertHouseInfoPath+"&mtyefmupn"+new Date().getMilliseconds()+"="+Math.random()
            	:insertHouseInfoPath+"?mtyefmupn"+new Date().getMilliseconds()+"="+Math.random(),
            width : 600,
            height : 312,
            title : KE.lang['insertHouseInfo'],
            yesButton : KE.lang['yes'],
            noButton : KE.lang['close']
        });
        dialog.show();
    },
    check : function(id) {
        var dialogDoc = KE.util.getIframeDoc(KE.g[id].dialog);
        var info = KE.$('info', dialogDoc).value;
        if (info=="") {
            alert("未能读取到房源信息，请选择房源信息!");
            window.focus();
            KE.g[id].yesButton.focus();
            return false;
        }
        return true;
    },
    exec : function(id) {
        KE.util.select(id);
        var dialogDoc = KE.util.getIframeDoc(KE.g[id].dialog);
        var info = KE.$('info', dialogDoc).value;
        if (!this.check(id)) return false;
        this.insert(id, info);
    },
    insert : function(id, info) {
		var tableId = id+Math.random(100);
    	var cssStyle = "{table:\"tableCss\",trOdd:\"trOdd\",trEven:\"trEven\"}";
    	var css = eval('(' + cssStyle + ')');
    	var d = KE.g[id].iframeDoc.getElementById("insertDiv");
    	if(d!=null){
    		KE.g[id].iframeDoc.body.removeChild(d);
    	}
        var html = "<div id='insertDiv'><table style='text-align: left' id='"+ tableId +"' border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\""+ css.table +"\" summary=\"房源列表\">"
        	+ "<tr>"
        	+ 	"<th style='width:60px;'>行政区</th>"
        	+ 	"<th style='width:120px;'>楼盘</th>"
        	+   "<th style='width:60px;'>楼层</th>"
        	+ 	"<th style='width:60px;'>户型</th>"
        	+ 	"<th style='width:60px;'>装修</th>"
        	+ 	"<th style='width:60px;'>面积</th>"
        	+ 	"<th style='width:60px;'>价格</th>"
        	+ 	"<th colspan=\"2\">查看</th>"
        	+ "</tr>";
        var builds = eval(info);
        for(index=0;index<builds.length;index++){
        	trCss = (index%2==0?css.trEven:css.trOdd);
        	html += "<tr class=\""+ trCss +"\" id='fun"+ builds[index].id +"'>"
	        	 + 	"<td>"+builds[index].region+"</td>"
	        	 + 	"<td>"+builds[index].building+"</td>"
	        	 + 	"<td>"+builds[index].floor+"</td>"
	        	 + 	"<td>"+builds[index].room+"</td>"
	        	 + 	"<td>"+builds[index].fitment+"</td>"
	        	 + 	"<td>"+builds[index].area+"</td>"
	        	 + 	"<td>"+builds[index].price+"</td>";
	        	 if(builds[index].photo!="0" && builds[index].photo!="null"){
	        	 	 html += "<td style='width:16px;'><a id=\"showImg_"+builds[index].id+"\" target=\"_self\" href=\"#\"  onclick=\"showHouseInfo(\'"+ builds[index].id +"\',\'"+builds[index].type+"\',\'"+ tableId +"\',this.parentNode.parentNode.rowIndex,this,'"+ builds[index].compNo +"','"+ builds[index].deptId+"','"+ builds[index].userId +"','"+builds[index].photoAddr+"');return false;\">图</a></td>";
	        	 }else{
	        	 	html += "<td style='width:16px;'></td>";
	        	 }
	      		 if(builds[index].charact!="" && builds[index].charact!="null"){
	        	 	html += "<td style='width:16px;'><a id=\"showTxt_"+builds[index].id+"\" target=\"_self\" href=\"#\" onclick=\"showHouseInfo(\'"+ builds[index].id +"\',\'"+builds[index].charact+"\',\'"+ tableId +"\',this.parentNode.parentNode.rowIndex,this,'"+ builds[index].compNo +"','"+ builds[index].deptId+"','"+ builds[index].userId +"');return false;\">文</a></td>";
	        	 }else{
	        	 	html += "<td style='width:16px;'></td>";	 
	        	 }	 	 
	        html += "</tr>";
        }
        html += "</table><br/><div>";
        KE.util.insertHtml(id, html);
        KE.layout.hide(id);
        KE.util.focus(id);
    },
    insert2 : function(id, info) {
    	var tableId = id+Math.random(100);
    	var cssStyle = "{table:\"border:1px solid #96c2f1;font-size:12px;\","
    				  + "th:\"background:#e8f5fe;color:d60000;height:25px;font-size:14px;padding-left:3px\","
    				  + "trOdd:\"background:#fff;height:22px;padding-left:3px\","
    				  + "trEven:\"background:#f5fafa;height:22px;padding-left:3px\"}";
    	var css = eval('(' + cssStyle + ')');
        var html = "<table id='"+ tableId +"' width=\"588\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\""+ css.table +"\" summary=\"房源列表\">"
        	+ "<tr style=\""+ css.th +"\">"
        	+ 	"<td>房源名称</td>"
        	+ 	"<td>小区名称</td>"
        	+ 	"<td>户型</td>"
        	+ 	"<td>面积</td>"
        	+ 	"<td>价格</td>"
        	+ 	"<td colspan=\"2\">查看</td>"
        	+ "</tr>";
        var builds = eval(info);
        for(index=0;index<builds.length;index++){
        	trCss = (index%2==0?css.trEven:css.trOdd);
        	html += "<tr style=\""+ trCss +"\" id='fun"+ builds[index].id +"'>"
	        	+ 	"<td>"+builds[index].building+"</td>"
	        	+ 	"<td>"+builds[index].street+"</td>"
	        	+ 	"<td>"+builds[index].room+"</td>"
	        	+ 	"<td>"+builds[index].area+"</td>"
	        	+ 	"<td>"+builds[index].price+"</td>";
	        	 if(builds[index].photo!="0"){
	        	 	 html += "<td><a href=\"#\" target=\"_self\" onclick=\"showHouseInfo(\'"+ builds[index].id +"\',\'"+builds[index].type+"\',\'"+ tableId +"\',this.parentNode.parentNode.rowIndex,this);return false;\">图</a></td>";
	        	 }else{
	        	 	html += "<td></td>";
	        	 }
	        	 if(builds[index].charact!="" && builds[index].charact!="null"){
	        	 	html += "<td><a href=\"#\" target=\"_self\" onclick=\"showHouseInfo(\'"+ builds[index].id +"\',\'"+builds[index].charact+"\',\'"+ tableId +"\',this.parentNode.parentNode.rowIndex,this);return false;\">文</a></td>";
	        	 }else{
	        	 	html += "<td></td>";	 
	        	 }
	        html += "</tr>";
        }
        html += "</table><br/>";
        KE.util.insertHtml(id, html);
        KE.layout.hide(id);
        KE.util.focus(id);
    }
};

//说明：type在查看图片和文字时，代表不同内容
var lastObj = "";
function showHouseInfo(id,type,tableId,index,obj,compNo,deptId,userId,photoAddr){
//alert(id+":::"+type+":::"+tableId+":::"+index+":::"+obj);
	var oTbody = document.getElementById(tableId);
	var trBox = document.getElementById("tr_"+id);
	var tdBox;
	//判断是否创建了行
	if(trBox!=null && typeof(trBox)!="undefined"){
		trBox.style.display = "";
	}else{
		var photoRow = oTbody.rows[index+1];
		var newRow = oTbody.insertRow(index+1);
		newRow.setAttribute("id","tr_"+id);
		tdBox = newRow.insertCell(0);
		tdBox.setAttribute("colSpan",9);
		tdBox.style.paddingLeft="0";
		tdBox.setAttribute("align","left");
	}
	lastObj = trBox;
	if(obj.innerHTML=="图"){
		changeImgandTxt(id,"image");//显示图时，关闭文字

		var imageBox = document.getElementById("images_"+id);
		if(imageBox==null){
			//var remoteService = new ServeVisitor();
			//var responseXml = remoteService.doService("showPhoto.jsp","id="+id+"&type="+type+"&compNo="+compNo+"&deptId="+deptId+"&userId="+userId);
			//responseXml=responseXml.trim();
			var photos = photoAddr.split(";");
			imageBox = document.createElement('div');
			imageBox.style.textAlign = "center";
			imageBox.style.marginTop = "10px";
			imageBox.setAttribute("id","images_"+id);
			for(var i=0;i<photos.length-1&&i<8;i++){
				var imgObj = KE.$$('img');
				imageBox.appendChild(imgObj);
				imgObj.style.width = "560px";
				imgObj.src = basePath+photos[i];
				imageBox.appendChild(KE.$$('br'));
				imageBox.appendChild(document.createTextNode("图"+(i+1)));
				imageBox.appendChild(KE.$$('br'));
			}
			//imgStr = imgStr+"<br/><div align='center'><img src=\"http://dns2.hftsoft.cn/pic/hftpic/house/"+photos[i]+"\"/><br/>图"+(i+1)+"<br/><div>";
			if(photos.length == 0){
				imageBox.appendChild(document.createTextNode("图片已被删除"));
			}
			setTimeout(function(){document.getElementById("tr_"+id).cells[0].appendChild(imageBox)},100);
		}
		obj.innerHTML="关";
		var showTxt = document.getElementById("showTxt_"+id);
		if(showTxt!=null && typeof(showTxt)!="undefined"){
			showTxt.innerHTML = "文";
		}
		imageBox.style.backgroundColor = "#DDEDFF";
	}else if(obj.innerHTML=="文"){
		changeImgandTxt(id,"text");//显示看图时，关闭文字
		var txtBox = document.getElementById("text_"+id);
		if(txtBox==null){
			if(type==""){
				type = "该内容已被删除";
			}
			txtBox = document.createElement('div');
			txtBox.setAttribute("id","text_"+id);
			//替换空行
			txtBox.innerHTML = type.replaceAll("&EACE","\r\n");
			document.getElementById("tr_"+id).cells[0].appendChild(txtBox);
		}
		txtBox.style.backgroundColor = "#FFFFF7";
		obj.innerHTML="关";
		var showImg = document.getElementById("showImg_"+id);
		if(showImg!=null){
			showImg.innerHTML = "图";
		}
	}else{
		if(lastObj!="")lastObj.style.display = "none";
		if(type=="sale" || type=="lease"){
			obj.innerHTML="图";
			changeImgandTxt(id,"image");
		}else{
			obj.innerHTML="文";
			changeImgandTxt(id,"text");
		}
	}
}
//type为image或者text
function changeImgandTxt(id,type){
var imgObj = document.getElementById("images_"+id);
var txtObj = document.getElementById("text_"+id);
var rtnObj;
	if(type=="image"){
		if(imgObj!=null)changeDisPlay(imgObj);
		if(txtObj!=null)txtObj.style.display = "none";
		rtnObj = imgObj;
	}else{
		if(imgObj!=null)imgObj.style.display = "none";
		if(txtObj!=null)changeDisPlay(txtObj);
		rtnObj = txtObj;
	}
	return rtnObj;
}
function changeDisPlay(obj){
	if(obj==null)return;
	if(obj.style.display==""){
		obj.style.display = "none";
	}else{
		obj.style.display = "";
	}
}

function setNullImg(obj){
	$(obj).removeAttr("onerror", "");
	obj.src = "./images/default.png";
}
function setImg(obj,src){
	obj.src = src;
}
