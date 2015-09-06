<!DOCTYPE html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("basePath", basePath.replace(":80/", "/"));
%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>nstSlider.js Demo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link type="text/css" rel="stylesheet" href="${basePath}js/jquery.nstSlider.css">
    <script src="${basePath}js/jquery-2.1.4.js"></script>
    <script src="${basePath}js/jquery.nstSlider.js"></script>
    <%--<script src="${basePath}js/jquery.netSlider.min.js"></script>--%>
    <style>
        body {
            min-width: 300px;
            max-width: 700px;
            margin: 0 auto;
            padding: 0px;
        }

    </style>
</head>
<body>
<h1>Get started with jquery.nstSlider.js</h1>
<!-- 2. Write markup for the slider -->
<div class="nstSlider" data-range_min="0" data-range_max="2" data-cur_min="0" data-cur_max="1">
    <div class="highlightPanel"></div>
    <div class="bar"></div>
    <div class="leftGrip"></div>
    <div class="rightGrip"></div>
</div>
<div class="leftLabel"></div>
<div class="rightLabel"></div>
<script>
    $('.nstSlider').nstSlider({
        "left_grip_selector": ".leftGrip",
        "right_grip_selector": ".rightGrip",
        "value_bar_selector": ".bar",
        "highlight": {
            "grip_class": "gripHighlighted",
            "panel_selector": ".highlightPanel"
        },
        "value_changed_callback": function (cause, leftValue, rightValue) {
            $('.leftLabel').text(leftValue);
            $('.rightLabel').text(rightValue);
        },
    });

    // Call methods and such...
    var highlightMin = Math.random() * 20,
            highlightMax = highlightMin + Math.random() * 80;
    $('.nstSlider').nstSlider('highlight_range', highlightMin, highlightMax);
</script>
</body>
</html>
