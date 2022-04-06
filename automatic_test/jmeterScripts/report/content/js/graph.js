/*
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
$(document).ready(function () {

    $(".click-title").mouseenter(function (e) {
        e.preventDefault();
        this.style.cursor = "pointer";
    });
    $(".click-title").mousedown(function (event) {
        event.preventDefault();
    });

    // Ugly code while this script is shared among several pages
    try {
        refreshHitsPerSecond(true);
    } catch (e) {
    }
    try {
        refreshResponseTimeOverTime(true);
    } catch (e) {
    }
    try {
        refreshResponseTimePercentiles();
    } catch (e) {
    }
});


var responseTimePercentilesInfos = {
    data: {
        "result": {
            "minY": 237.0, "minX": 0.0, "maxY": 422.0, "series": [{
                "data": [[0.0, 237.0], [0.1, 237.0], [0.2, 237.0], [0.3, 237.0], [0.4, 237.0], [0.5, 237.0], [0.6, 237.0], [0.7, 237.0], [0.8, 237.0], [0.9, 237.0], [1.0, 241.0], [1.1, 241.0], [1.2, 241.0], [1.3, 241.0], [1.4, 241.0], [1.5, 241.0], [1.6, 241.0], [1.7, 241.0], [1.8, 241.0], [1.9, 241.0], [2.0, 242.0], [2.1, 242.0], [2.2, 242.0], [2.3, 242.0], [2.4, 242.0], [2.5, 242.0], [2.6, 242.0], [2.7, 242.0], [2.8, 242.0], [2.9, 242.0], [3.0, 242.0], [3.1, 242.0], [3.2, 242.0], [3.3, 242.0], [3.4, 242.0], [3.5, 242.0], [3.6, 242.0], [3.7, 242.0], [3.8, 242.0], [3.9, 242.0], [4.0, 242.0], [4.1, 242.0], [4.2, 242.0], [4.3, 242.0], [4.4, 242.0], [4.5, 242.0], [4.6, 242.0], [4.7, 242.0], [4.8, 242.0], [4.9, 242.0], [5.0, 243.0], [5.1, 243.0], [5.2, 243.0], [5.3, 243.0], [5.4, 243.0], [5.5, 243.0], [5.6, 243.0], [5.7, 243.0], [5.8, 243.0], [5.9, 243.0], [6.0, 243.0], [6.1, 243.0], [6.2, 243.0], [6.3, 243.0], [6.4, 243.0], [6.5, 243.0], [6.6, 243.0], [6.7, 243.0], [6.8, 243.0], [6.9, 243.0], [7.0, 243.0], [7.1, 243.0], [7.2, 243.0], [7.3, 243.0], [7.4, 243.0], [7.5, 243.0], [7.6, 243.0], [7.7, 243.0], [7.8, 243.0], [7.9, 243.0], [8.0, 244.0], [8.1, 244.0], [8.2, 244.0], [8.3, 244.0], [8.4, 244.0], [8.5, 244.0], [8.6, 244.0], [8.7, 244.0], [8.8, 244.0], [8.9, 244.0], [9.0, 245.0], [9.1, 245.0], [9.2, 245.0], [9.3, 245.0], [9.4, 245.0], [9.5, 245.0], [9.6, 245.0], [9.7, 245.0], [9.8, 245.0], [9.9, 245.0], [10.0, 246.0], [10.1, 246.0], [10.2, 246.0], [10.3, 246.0], [10.4, 246.0], [10.5, 246.0], [10.6, 246.0], [10.7, 246.0], [10.8, 246.0], [10.9, 246.0], [11.0, 246.0], [11.1, 246.0], [11.2, 246.0], [11.3, 246.0], [11.4, 246.0], [11.5, 246.0], [11.6, 246.0], [11.7, 246.0], [11.8, 246.0], [11.9, 246.0], [12.0, 246.0], [12.1, 246.0], [12.2, 246.0], [12.3, 246.0], [12.4, 246.0], [12.5, 246.0], [12.6, 246.0], [12.7, 246.0], [12.8, 246.0], [12.9, 246.0], [13.0, 246.0], [13.1, 246.0], [13.2, 246.0], [13.3, 246.0], [13.4, 246.0], [13.5, 246.0], [13.6, 246.0], [13.7, 246.0], [13.8, 246.0], [13.9, 246.0], [14.0, 247.0], [14.1, 247.0], [14.2, 247.0], [14.3, 247.0], [14.4, 247.0], [14.5, 247.0], [14.6, 247.0], [14.7, 247.0], [14.8, 247.0], [14.9, 247.0], [15.0, 247.0], [15.1, 247.0], [15.2, 247.0], [15.3, 247.0], [15.4, 247.0], [15.5, 247.0], [15.6, 247.0], [15.7, 247.0], [15.8, 247.0], [15.9, 247.0], [16.0, 248.0], [16.1, 248.0], [16.2, 248.0], [16.3, 248.0], [16.4, 248.0], [16.5, 248.0], [16.6, 248.0], [16.7, 248.0], [16.8, 248.0], [16.9, 248.0], [17.0, 249.0], [17.1, 249.0], [17.2, 249.0], [17.3, 249.0], [17.4, 249.0], [17.5, 249.0], [17.6, 249.0], [17.7, 249.0], [17.8, 249.0], [17.9, 249.0], [18.0, 249.0], [18.1, 249.0], [18.2, 249.0], [18.3, 249.0], [18.4, 249.0], [18.5, 249.0], [18.6, 249.0], [18.7, 249.0], [18.8, 249.0], [18.9, 249.0], [19.0, 249.0], [19.1, 249.0], [19.2, 249.0], [19.3, 249.0], [19.4, 249.0], [19.5, 249.0], [19.6, 249.0], [19.7, 249.0], [19.8, 249.0], [19.9, 249.0], [20.0, 250.0], [20.1, 250.0], [20.2, 250.0], [20.3, 250.0], [20.4, 250.0], [20.5, 250.0], [20.6, 250.0], [20.7, 250.0], [20.8, 250.0], [20.9, 250.0], [21.0, 251.0], [21.1, 251.0], [21.2, 251.0], [21.3, 251.0], [21.4, 251.0], [21.5, 251.0], [21.6, 251.0], [21.7, 251.0], [21.8, 251.0], [21.9, 251.0], [22.0, 252.0], [22.1, 252.0], [22.2, 252.0], [22.3, 252.0], [22.4, 252.0], [22.5, 252.0], [22.6, 252.0], [22.7, 252.0], [22.8, 252.0], [22.9, 252.0], [23.0, 253.0], [23.1, 253.0], [23.2, 253.0], [23.3, 253.0], [23.4, 253.0], [23.5, 253.0], [23.6, 253.0], [23.7, 253.0], [23.8, 253.0], [23.9, 253.0], [24.0, 253.0], [24.1, 253.0], [24.2, 253.0], [24.3, 253.0], [24.4, 253.0], [24.5, 253.0], [24.6, 253.0], [24.7, 253.0], [24.8, 253.0], [24.9, 253.0], [25.0, 254.0], [25.1, 254.0], [25.2, 254.0], [25.3, 254.0], [25.4, 254.0], [25.5, 254.0], [25.6, 254.0], [25.7, 254.0], [25.8, 254.0], [25.9, 254.0], [26.0, 255.0], [26.1, 255.0], [26.2, 255.0], [26.3, 255.0], [26.4, 255.0], [26.5, 255.0], [26.6, 255.0], [26.7, 255.0], [26.8, 255.0], [26.9, 255.0], [27.0, 256.0], [27.1, 256.0], [27.2, 256.0], [27.3, 256.0], [27.4, 256.0], [27.5, 256.0], [27.6, 256.0], [27.7, 256.0], [27.8, 256.0], [27.9, 256.0], [28.0, 257.0], [28.1, 257.0], [28.2, 257.0], [28.3, 257.0], [28.4, 257.0], [28.5, 257.0], [28.6, 257.0], [28.7, 257.0], [28.8, 257.0], [28.9, 257.0], [29.0, 258.0], [29.1, 258.0], [29.2, 258.0], [29.3, 258.0], [29.4, 258.0], [29.5, 258.0], [29.6, 258.0], [29.7, 258.0], [29.8, 258.0], [29.9, 258.0], [30.0, 258.0], [30.1, 258.0], [30.2, 258.0], [30.3, 258.0], [30.4, 258.0], [30.5, 258.0], [30.6, 258.0], [30.7, 258.0], [30.8, 258.0], [30.9, 258.0], [31.0, 258.0], [31.1, 258.0], [31.2, 258.0], [31.3, 258.0], [31.4, 258.0], [31.5, 258.0], [31.6, 258.0], [31.7, 258.0], [31.8, 258.0], [31.9, 258.0], [32.0, 258.0], [32.1, 258.0], [32.2, 258.0], [32.3, 258.0], [32.4, 258.0], [32.5, 258.0], [32.6, 258.0], [32.7, 258.0], [32.8, 258.0], [32.9, 258.0], [33.0, 259.0], [33.1, 259.0], [33.2, 259.0], [33.3, 259.0], [33.4, 259.0], [33.5, 259.0], [33.6, 259.0], [33.7, 259.0], [33.8, 259.0], [33.9, 259.0], [34.0, 261.0], [34.1, 261.0], [34.2, 261.0], [34.3, 261.0], [34.4, 261.0], [34.5, 261.0], [34.6, 261.0], [34.7, 261.0], [34.8, 261.0], [34.9, 261.0], [35.0, 261.0], [35.1, 261.0], [35.2, 261.0], [35.3, 261.0], [35.4, 261.0], [35.5, 261.0], [35.6, 261.0], [35.7, 261.0], [35.8, 261.0], [35.9, 261.0], [36.0, 261.0], [36.1, 261.0], [36.2, 261.0], [36.3, 261.0], [36.4, 261.0], [36.5, 261.0], [36.6, 261.0], [36.7, 261.0], [36.8, 261.0], [36.9, 261.0], [37.0, 263.0], [37.1, 263.0], [37.2, 263.0], [37.3, 263.0], [37.4, 263.0], [37.5, 263.0], [37.6, 263.0], [37.7, 263.0], [37.8, 263.0], [37.9, 263.0], [38.0, 263.0], [38.1, 263.0], [38.2, 263.0], [38.3, 263.0], [38.4, 263.0], [38.5, 263.0], [38.6, 263.0], [38.7, 263.0], [38.8, 263.0], [38.9, 263.0], [39.0, 264.0], [39.1, 264.0], [39.2, 264.0], [39.3, 264.0], [39.4, 264.0], [39.5, 264.0], [39.6, 264.0], [39.7, 264.0], [39.8, 264.0], [39.9, 264.0], [40.0, 265.0], [40.1, 265.0], [40.2, 265.0], [40.3, 265.0], [40.4, 265.0], [40.5, 265.0], [40.6, 265.0], [40.7, 265.0], [40.8, 265.0], [40.9, 265.0], [41.0, 265.0], [41.1, 265.0], [41.2, 265.0], [41.3, 265.0], [41.4, 265.0], [41.5, 265.0], [41.6, 265.0], [41.7, 265.0], [41.8, 265.0], [41.9, 265.0], [42.0, 276.0], [42.1, 276.0], [42.2, 276.0], [42.3, 276.0], [42.4, 276.0], [42.5, 276.0], [42.6, 276.0], [42.7, 276.0], [42.8, 276.0], [42.9, 276.0], [43.0, 278.0], [43.1, 278.0], [43.2, 278.0], [43.3, 278.0], [43.4, 278.0], [43.5, 278.0], [43.6, 278.0], [43.7, 278.0], [43.8, 278.0], [43.9, 278.0], [44.0, 279.0], [44.1, 279.0], [44.2, 279.0], [44.3, 279.0], [44.4, 279.0], [44.5, 279.0], [44.6, 279.0], [44.7, 279.0], [44.8, 279.0], [44.9, 279.0], [45.0, 280.0], [45.1, 280.0], [45.2, 280.0], [45.3, 280.0], [45.4, 280.0], [45.5, 280.0], [45.6, 280.0], [45.7, 280.0], [45.8, 280.0], [45.9, 280.0], [46.0, 281.0], [46.1, 281.0], [46.2, 281.0], [46.3, 281.0], [46.4, 281.0], [46.5, 281.0], [46.6, 281.0], [46.7, 281.0], [46.8, 281.0], [46.9, 281.0], [47.0, 281.0], [47.1, 281.0], [47.2, 281.0], [47.3, 281.0], [47.4, 281.0], [47.5, 281.0], [47.6, 281.0], [47.7, 281.0], [47.8, 281.0], [47.9, 281.0], [48.0, 281.0], [48.1, 281.0], [48.2, 281.0], [48.3, 281.0], [48.4, 281.0], [48.5, 281.0], [48.6, 281.0], [48.7, 281.0], [48.8, 281.0], [48.9, 281.0], [49.0, 281.0], [49.1, 281.0], [49.2, 281.0], [49.3, 281.0], [49.4, 281.0], [49.5, 281.0], [49.6, 281.0], [49.7, 281.0], [49.8, 281.0], [49.9, 281.0], [50.0, 282.0], [50.1, 282.0], [50.2, 282.0], [50.3, 282.0], [50.4, 282.0], [50.5, 282.0], [50.6, 282.0], [50.7, 282.0], [50.8, 282.0], [50.9, 282.0], [51.0, 282.0], [51.1, 282.0], [51.2, 282.0], [51.3, 282.0], [51.4, 282.0], [51.5, 282.0], [51.6, 282.0], [51.7, 282.0], [51.8, 282.0], [51.9, 282.0], [52.0, 282.0], [52.1, 282.0], [52.2, 282.0], [52.3, 282.0], [52.4, 282.0], [52.5, 282.0], [52.6, 282.0], [52.7, 282.0], [52.8, 282.0], [52.9, 282.0], [53.0, 282.0], [53.1, 282.0], [53.2, 282.0], [53.3, 282.0], [53.4, 282.0], [53.5, 282.0], [53.6, 282.0], [53.7, 282.0], [53.8, 282.0], [53.9, 282.0], [54.0, 283.0], [54.1, 283.0], [54.2, 283.0], [54.3, 283.0], [54.4, 283.0], [54.5, 283.0], [54.6, 283.0], [54.7, 283.0], [54.8, 283.0], [54.9, 283.0], [55.0, 283.0], [55.1, 283.0], [55.2, 283.0], [55.3, 283.0], [55.4, 283.0], [55.5, 283.0], [55.6, 283.0], [55.7, 283.0], [55.8, 283.0], [55.9, 283.0], [56.0, 283.0], [56.1, 283.0], [56.2, 283.0], [56.3, 283.0], [56.4, 283.0], [56.5, 283.0], [56.6, 283.0], [56.7, 283.0], [56.8, 283.0], [56.9, 283.0], [57.0, 283.0], [57.1, 283.0], [57.2, 283.0], [57.3, 283.0], [57.4, 283.0], [57.5, 283.0], [57.6, 283.0], [57.7, 283.0], [57.8, 283.0], [57.9, 283.0], [58.0, 283.0], [58.1, 283.0], [58.2, 283.0], [58.3, 283.0], [58.4, 283.0], [58.5, 283.0], [58.6, 283.0], [58.7, 283.0], [58.8, 283.0], [58.9, 283.0], [59.0, 284.0], [59.1, 284.0], [59.2, 284.0], [59.3, 284.0], [59.4, 284.0], [59.5, 284.0], [59.6, 284.0], [59.7, 284.0], [59.8, 284.0], [59.9, 284.0], [60.0, 284.0], [60.1, 284.0], [60.2, 284.0], [60.3, 284.0], [60.4, 284.0], [60.5, 284.0], [60.6, 284.0], [60.7, 284.0], [60.8, 284.0], [60.9, 284.0], [61.0, 284.0], [61.1, 284.0], [61.2, 284.0], [61.3, 284.0], [61.4, 284.0], [61.5, 284.0], [61.6, 284.0], [61.7, 284.0], [61.8, 284.0], [61.9, 284.0], [62.0, 284.0], [62.1, 284.0], [62.2, 284.0], [62.3, 284.0], [62.4, 284.0], [62.5, 284.0], [62.6, 284.0], [62.7, 284.0], [62.8, 284.0], [62.9, 284.0], [63.0, 285.0], [63.1, 285.0], [63.2, 285.0], [63.3, 285.0], [63.4, 285.0], [63.5, 285.0], [63.6, 285.0], [63.7, 285.0], [63.8, 285.0], [63.9, 285.0], [64.0, 285.0], [64.1, 285.0], [64.2, 285.0], [64.3, 285.0], [64.4, 285.0], [64.5, 285.0], [64.6, 285.0], [64.7, 285.0], [64.8, 285.0], [64.9, 285.0], [65.0, 286.0], [65.1, 286.0], [65.2, 286.0], [65.3, 286.0], [65.4, 286.0], [65.5, 286.0], [65.6, 286.0], [65.7, 286.0], [65.8, 286.0], [65.9, 286.0], [66.0, 286.0], [66.1, 286.0], [66.2, 286.0], [66.3, 286.0], [66.4, 286.0], [66.5, 286.0], [66.6, 286.0], [66.7, 286.0], [66.8, 286.0], [66.9, 286.0], [67.0, 286.0], [67.1, 286.0], [67.2, 286.0], [67.3, 286.0], [67.4, 286.0], [67.5, 286.0], [67.6, 286.0], [67.7, 286.0], [67.8, 286.0], [67.9, 286.0], [68.0, 286.0], [68.1, 286.0], [68.2, 286.0], [68.3, 286.0], [68.4, 286.0], [68.5, 286.0], [68.6, 286.0], [68.7, 286.0], [68.8, 286.0], [68.9, 286.0], [69.0, 287.0], [69.1, 287.0], [69.2, 287.0], [69.3, 287.0], [69.4, 287.0], [69.5, 287.0], [69.6, 287.0], [69.7, 287.0], [69.8, 287.0], [69.9, 287.0], [70.0, 287.0], [70.1, 287.0], [70.2, 287.0], [70.3, 287.0], [70.4, 287.0], [70.5, 287.0], [70.6, 287.0], [70.7, 287.0], [70.8, 287.0], [70.9, 287.0], [71.0, 287.0], [71.1, 287.0], [71.2, 287.0], [71.3, 287.0], [71.4, 287.0], [71.5, 287.0], [71.6, 287.0], [71.7, 287.0], [71.8, 287.0], [71.9, 287.0], [72.0, 287.0], [72.1, 287.0], [72.2, 287.0], [72.3, 287.0], [72.4, 287.0], [72.5, 287.0], [72.6, 287.0], [72.7, 287.0], [72.8, 287.0], [72.9, 287.0], [73.0, 289.0], [73.1, 289.0], [73.2, 289.0], [73.3, 289.0], [73.4, 289.0], [73.5, 289.0], [73.6, 289.0], [73.7, 289.0], [73.8, 289.0], [73.9, 289.0], [74.0, 289.0], [74.1, 289.0], [74.2, 289.0], [74.3, 289.0], [74.4, 289.0], [74.5, 289.0], [74.6, 289.0], [74.7, 289.0], [74.8, 289.0], [74.9, 289.0], [75.0, 289.0], [75.1, 289.0], [75.2, 289.0], [75.3, 289.0], [75.4, 289.0], [75.5, 289.0], [75.6, 289.0], [75.7, 289.0], [75.8, 289.0], [75.9, 289.0], [76.0, 289.0], [76.1, 289.0], [76.2, 289.0], [76.3, 289.0], [76.4, 289.0], [76.5, 289.0], [76.6, 289.0], [76.7, 289.0], [76.8, 289.0], [76.9, 289.0], [77.0, 290.0], [77.1, 290.0], [77.2, 290.0], [77.3, 290.0], [77.4, 290.0], [77.5, 290.0], [77.6, 290.0], [77.7, 290.0], [77.8, 290.0], [77.9, 290.0], [78.0, 290.0], [78.1, 290.0], [78.2, 290.0], [78.3, 290.0], [78.4, 290.0], [78.5, 290.0], [78.6, 290.0], [78.7, 290.0], [78.8, 290.0], [78.9, 290.0], [79.0, 293.0], [79.1, 293.0], [79.2, 293.0], [79.3, 293.0], [79.4, 293.0], [79.5, 293.0], [79.6, 293.0], [79.7, 293.0], [79.8, 293.0], [79.9, 293.0], [80.0, 293.0], [80.1, 293.0], [80.2, 293.0], [80.3, 293.0], [80.4, 293.0], [80.5, 293.0], [80.6, 293.0], [80.7, 293.0], [80.8, 293.0], [80.9, 293.0], [81.0, 294.0], [81.1, 294.0], [81.2, 294.0], [81.3, 294.0], [81.4, 294.0], [81.5, 294.0], [81.6, 294.0], [81.7, 294.0], [81.8, 294.0], [81.9, 294.0], [82.0, 295.0], [82.1, 295.0], [82.2, 295.0], [82.3, 295.0], [82.4, 295.0], [82.5, 295.0], [82.6, 295.0], [82.7, 295.0], [82.8, 295.0], [82.9, 295.0], [83.0, 295.0], [83.1, 295.0], [83.2, 295.0], [83.3, 295.0], [83.4, 295.0], [83.5, 295.0], [83.6, 295.0], [83.7, 295.0], [83.8, 295.0], [83.9, 295.0], [84.0, 295.0], [84.1, 295.0], [84.2, 295.0], [84.3, 295.0], [84.4, 295.0], [84.5, 295.0], [84.6, 295.0], [84.7, 295.0], [84.8, 295.0], [84.9, 295.0], [85.0, 296.0], [85.1, 296.0], [85.2, 296.0], [85.3, 296.0], [85.4, 296.0], [85.5, 296.0], [85.6, 296.0], [85.7, 296.0], [85.8, 296.0], [85.9, 296.0], [86.0, 298.0], [86.1, 298.0], [86.2, 298.0], [86.3, 298.0], [86.4, 298.0], [86.5, 298.0], [86.6, 298.0], [86.7, 298.0], [86.8, 298.0], [86.9, 298.0], [87.0, 299.0], [87.1, 299.0], [87.2, 299.0], [87.3, 299.0], [87.4, 299.0], [87.5, 299.0], [87.6, 299.0], [87.7, 299.0], [87.8, 299.0], [87.9, 299.0], [88.0, 299.0], [88.1, 299.0], [88.2, 299.0], [88.3, 299.0], [88.4, 299.0], [88.5, 299.0], [88.6, 299.0], [88.7, 299.0], [88.8, 299.0], [88.9, 299.0], [89.0, 300.0], [89.1, 300.0], [89.2, 300.0], [89.3, 300.0], [89.4, 300.0], [89.5, 300.0], [89.6, 300.0], [89.7, 300.0], [89.8, 300.0], [89.9, 300.0], [90.0, 300.0], [90.1, 300.0], [90.2, 300.0], [90.3, 300.0], [90.4, 300.0], [90.5, 300.0], [90.6, 300.0], [90.7, 300.0], [90.8, 300.0], [90.9, 300.0], [91.0, 300.0], [91.1, 300.0], [91.2, 300.0], [91.3, 300.0], [91.4, 300.0], [91.5, 300.0], [91.6, 300.0], [91.7, 300.0], [91.8, 300.0], [91.9, 300.0], [92.0, 302.0], [92.1, 302.0], [92.2, 302.0], [92.3, 302.0], [92.4, 302.0], [92.5, 302.0], [92.6, 302.0], [92.7, 302.0], [92.8, 302.0], [92.9, 302.0], [93.0, 302.0], [93.1, 302.0], [93.2, 302.0], [93.3, 302.0], [93.4, 302.0], [93.5, 302.0], [93.6, 302.0], [93.7, 302.0], [93.8, 302.0], [93.9, 302.0], [94.0, 311.0], [94.1, 311.0], [94.2, 311.0], [94.3, 311.0], [94.4, 311.0], [94.5, 311.0], [94.6, 311.0], [94.7, 311.0], [94.8, 311.0], [94.9, 311.0], [95.0, 312.0], [95.1, 312.0], [95.2, 312.0], [95.3, 312.0], [95.4, 312.0], [95.5, 312.0], [95.6, 312.0], [95.7, 312.0], [95.8, 312.0], [95.9, 312.0], [96.0, 312.0], [96.1, 312.0], [96.2, 312.0], [96.3, 312.0], [96.4, 312.0], [96.5, 312.0], [96.6, 312.0], [96.7, 312.0], [96.8, 312.0], [96.9, 312.0], [97.0, 412.0], [97.1, 412.0], [97.2, 412.0], [97.3, 412.0], [97.4, 412.0], [97.5, 412.0], [97.6, 412.0], [97.7, 412.0], [97.8, 412.0], [97.9, 412.0], [98.0, 413.0], [98.1, 413.0], [98.2, 413.0], [98.3, 413.0], [98.4, 413.0], [98.5, 413.0], [98.6, 413.0], [98.7, 413.0], [98.8, 413.0], [98.9, 413.0], [99.0, 422.0], [99.1, 422.0], [99.2, 422.0], [99.3, 422.0], [99.4, 422.0], [99.5, 422.0], [99.6, 422.0], [99.7, 422.0], [99.8, 422.0], [99.9, 422.0]],
                "isOverall": false,
                "label": "HTTP请求",
                "isController": false
            }], "supportsControllersDiscrimination": true, "maxX": 100.0, "title": "Response Time Percentiles"
        }
    },
    getOptions: function () {
        return {
            series: {
                points: {show: false}
            },
            legend: {
                noColumns: 2,
                show: true,
                container: '#legendResponseTimePercentiles'
            },
            xaxis: {
                tickDecimals: 1,
                axisLabel: "Percentiles",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Percentile value in ms",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to
                                // work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s : %x.2 percentile was %y ms"
            },
            selection: {mode: "xy"},
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesResponseTimePercentiles"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotResponseTimesPercentiles"), dataset, options);
        // setup overview
        $.plot($("#overviewResponseTimesPercentiles"), dataset, prepareOverviewOptions(options));
    }
};

/**
 * @param elementId Id of element where we display message
 */
function setEmptyGraph(elementId) {
    $(function () {
        $(elementId).text("No graph series with filter=" + seriesFilter);
    });
}

// Response times percentiles
function refreshResponseTimePercentiles() {
    var infos = responseTimePercentilesInfos;
    prepareSeries(infos.data);
    if (infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyResponseTimePercentiles");
        return;
    }
    if (isGraph($("#flotResponseTimesPercentiles"))) {
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesResponseTimePercentiles");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimesPercentiles", "#overviewResponseTimesPercentiles");
        $('#bodyResponseTimePercentiles .legendColorBox > div').each(function (i) {
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
}

var responseTimeDistributionInfos = {
    data: {
        "result": {
            "minY": 3.0,
            "minX": 200.0,
            "maxY": 89.0,
            "series": [{
                "data": [[300.0, 8.0], [200.0, 89.0], [400.0, 3.0]],
                "isOverall": false,
                "label": "HTTP请求",
                "isController": false
            }],
            "supportsControllersDiscrimination": true,
            "granularity": 100,
            "maxX": 400.0,
            "title": "Response Time Distribution"
        }
    },
    getOptions: function () {
        var granularity = this.data.result.granularity;
        return {
            legend: {
                noColumns: 2,
                show: true,
                container: '#legendResponseTimeDistribution'
            },
            xaxis: {
                axisLabel: "Response times in ms",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Number of responses",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            bars: {
                show: true,
                barWidth: this.data.result.granularity
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to
                                // work
            },
            tooltip: true,
            tooltipOpts: {
                content: function (label, xval, yval, flotItem) {
                    return yval + " responses for " + label + " were between " + xval + " and " + (xval + granularity) + " ms";
                }
            }
        };
    },
    createGraph: function () {
        var data = this.data;
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotResponseTimeDistribution"), prepareData(data.result.series, $("#choicesResponseTimeDistribution")), options);
    }

};

// Response time distribution
function refreshResponseTimeDistribution() {
    var infos = responseTimeDistributionInfos;
    prepareSeries(infos.data);
    if (infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyResponseTimeDistribution");
        return;
    }
    if (isGraph($("#flotResponseTimeDistribution"))) {
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesResponseTimeDistribution");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        $('#footerResponseTimeDistribution .legendColorBox > div').each(function (i) {
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};


var syntheticResponseTimeDistributionInfos = {
    data: {
        "result": {
            "minY": 100.0,
            "minX": 0.0,
            "ticks": [[0, "Requests having \nresponse time <= 500ms"], [1, "Requests having \nresponse time > 500ms and <= 1,500ms"], [2, "Requests having \nresponse time > 1,500ms"], [3, "Requests in error"]],
            "maxY": 100.0,
            "series": [{
                "data": [[0.0, 100.0]],
                "color": "#9ACD32",
                "isOverall": false,
                "label": "Requests having \nresponse time <= 500ms",
                "isController": false
            }, {
                "data": [],
                "color": "yellow",
                "isOverall": false,
                "label": "Requests having \nresponse time > 500ms and <= 1,500ms",
                "isController": false
            }, {
                "data": [],
                "color": "orange",
                "isOverall": false,
                "label": "Requests having \nresponse time > 1,500ms",
                "isController": false
            }, {
                "data": [],
                "color": "#FF6347",
                "isOverall": false,
                "label": "Requests in error",
                "isController": false
            }],
            "supportsControllersDiscrimination": false,
            "maxX": 4.9E-324,
            "title": "Synthetic Response Times Distribution"
        }
    },
    getOptions: function () {
        return {
            legend: {
                noColumns: 2,
                show: true,
                container: '#legendSyntheticResponseTimeDistribution'
            },
            xaxis: {
                axisLabel: "Response times ranges",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
                tickLength: 0,
                min: -0.5,
                max: 3.5
            },
            yaxis: {
                axisLabel: "Number of responses",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            bars: {
                show: true,
                align: "center",
                barWidth: 0.25,
                fill: .75
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to
                                // work
            },
            tooltip: true,
            tooltipOpts: {
                content: function (label, xval, yval, flotItem) {
                    return yval + " " + label;
                }
            }
        };
    },
    createGraph: function () {
        var data = this.data;
        var options = this.getOptions();
        prepareOptions(options, data);
        options.xaxis.ticks = data.result.ticks;
        $.plot($("#flotSyntheticResponseTimeDistribution"), prepareData(data.result.series, $("#choicesSyntheticResponseTimeDistribution")), options);
    }

};

// Response time distribution
function refreshSyntheticResponseTimeDistribution() {
    var infos = syntheticResponseTimeDistributionInfos;
    prepareSeries(infos.data, true);
    if (isGraph($("#flotSyntheticResponseTimeDistribution"))) {
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesSyntheticResponseTimeDistribution");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        $('#footerSyntheticResponseTimeDistribution .legendColorBox > div').each(function (i) {
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var activeThreadsOverTimeInfos = {
    data: {
        "result": {
            "minY": 54.58,
            "minX": 1.64907222E12,
            "maxY": 54.58,
            "series": [{"data": [[1.64907222E12, 54.58]], "isOverall": false, "label": "定时器", "isController": false}],
            "supportsControllersDiscrimination": false,
            "granularity": 60000,
            "maxX": 1.64907222E12,
            "title": "Active Threads Over Time"
        }
    },
    getOptions: function () {
        return {
            series: {
                stack: true,
                lines: {
                    show: true,
                    fill: true
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                mode: "time",
                timeformat: getTimeFormat(this.data.result.granularity),
                axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Number of active threads",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20
            },
            legend: {
                noColumns: 6,
                show: true,
                container: '#legendActiveThreadsOverTime'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to
                                // work
            },
            selection: {
                mode: 'xy'
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s : At %x there were %y active threads"
            }
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesActiveThreadsOverTime"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotActiveThreadsOverTime"), dataset, options);
        // setup overview
        $.plot($("#overviewActiveThreadsOverTime"), dataset, prepareOverviewOptions(options));
    }
};

// Active Threads Over Time
function refreshActiveThreadsOverTime(fixTimestamps) {
    var infos = activeThreadsOverTimeInfos;
    prepareSeries(infos.data);
    if (fixTimestamps) {
        fixTimeStamps(infos.data.result.series, 28800000);
    }
    if (isGraph($("#flotActiveThreadsOverTime"))) {
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesActiveThreadsOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotActiveThreadsOverTime", "#overviewActiveThreadsOverTime");
        $('#footerActiveThreadsOverTime .legendColorBox > div').each(function (i) {
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var timeVsThreadsInfos = {
    data: {
        "result": {
            "minY": 244.33333333333334,
            "minX": 3.0,
            "maxY": 415.6666666666667,
            "series": [{
                "data": [[33.0, 287.4], [32.0, 286.0], [39.0, 284.33333333333337], [48.0, 282.0], [3.0, 415.6666666666667], [51.0, 281.25], [52.0, 285.0], [54.0, 282.75], [56.0, 281.0], [58.0, 281.8333333333333], [60.0, 265.0], [63.0, 260.3333333333333], [68.0, 258.6], [72.0, 257.25], [83.0, 254.7142857142857], [88.0, 252.0], [6.0, 311.6666666666667], [100.0, 244.33333333333334], [7.0, 302.0], [9.0, 300.0], [11.0, 300.5], [17.0, 296.1666666666667], [19.0, 295.0], [20.0, 294.0], [22.0, 288.5], [26.0, 290.6666666666667], [27.0, 286.0]],
                "isOverall": false,
                "label": "HTTP请求",
                "isController": false
            }, {
                "data": [[54.55, 277.27000000000004]],
                "isOverall": false,
                "label": "HTTP请求-Aggregated",
                "isController": false
            }],
            "supportsControllersDiscrimination": true,
            "maxX": 100.0,
            "title": "Time VS Threads"
        }
    },
    getOptions: function () {
        return {
            series: {
                lines: {
                    show: true
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                axisLabel: "Number of active threads",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Average response times in ms",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20
            },
            legend: {noColumns: 2, show: true, container: '#legendTimeVsThreads'},
            selection: {
                mode: 'xy'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s: At %x.2 active threads, Average response time was %y.2 ms"
            }
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesTimeVsThreads"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotTimesVsThreads"), dataset, options);
        // setup overview
        $.plot($("#overviewTimesVsThreads"), dataset, prepareOverviewOptions(options));
    }
};

// Time vs threads
function refreshTimeVsThreads() {
    var infos = timeVsThreadsInfos;
    prepareSeries(infos.data);
    if (infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyTimeVsThreads");
        return;
    }
    if (isGraph($("#flotTimesVsThreads"))) {
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesTimeVsThreads");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotTimesVsThreads", "#overviewTimesVsThreads");
        $('#footerTimeVsThreads .legendColorBox > div').each(function (i) {
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var bytesThroughputOverTimeInfos = {
    data: {
        "result": {
            "minY": 193.33333333333334,
            "minX": 1.64907222E12,
            "maxY": 4161.666666666667,
            "series": [{
                "data": [[1.64907222E12, 4161.666666666667]],
                "isOverall": false,
                "label": "Bytes received per second",
                "isController": false
            }, {
                "data": [[1.64907222E12, 193.33333333333334]],
                "isOverall": false,
                "label": "Bytes sent per second",
                "isController": false
            }],
            "supportsControllersDiscrimination": false,
            "granularity": 60000,
            "maxX": 1.64907222E12,
            "title": "Bytes Throughput Over Time"
        }
    },
    getOptions: function () {
        return {
            series: {
                lines: {
                    show: true
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                mode: "time",
                timeformat: getTimeFormat(this.data.result.granularity),
                axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Bytes / sec",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            legend: {
                noColumns: 2,
                show: true,
                container: '#legendBytesThroughputOverTime'
            },
            selection: {
                mode: "xy"
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to
                                // work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s at %x was %y"
            }
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesBytesThroughputOverTime"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotBytesThroughputOverTime"), dataset, options);
        // setup overview
        $.plot($("#overviewBytesThroughputOverTime"), dataset, prepareOverviewOptions(options));
    }
};

// Bytes throughput Over Time
function refreshBytesThroughputOverTime(fixTimestamps) {
    var infos = bytesThroughputOverTimeInfos;
    prepareSeries(infos.data);
    if (fixTimestamps) {
        fixTimeStamps(infos.data.result.series, 28800000);
    }
    if (isGraph($("#flotBytesThroughputOverTime"))) {
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesBytesThroughputOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotBytesThroughputOverTime", "#overviewBytesThroughputOverTime");
        $('#footerBytesThroughputOverTime .legendColorBox > div').each(function (i) {
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
}

var responseTimesOverTimeInfos = {
    data: {
        "result": {
            "minY": 277.27000000000004,
            "minX": 1.64907222E12,
            "maxY": 277.27000000000004,
            "series": [{
                "data": [[1.64907222E12, 277.27000000000004]],
                "isOverall": false,
                "label": "HTTP请求",
                "isController": false
            }],
            "supportsControllersDiscrimination": true,
            "granularity": 60000,
            "maxX": 1.64907222E12,
            "title": "Response Time Over Time"
        }
    },
    getOptions: function () {
        return {
            series: {
                lines: {
                    show: true
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                mode: "time",
                timeformat: getTimeFormat(this.data.result.granularity),
                axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Average response time in ms",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            legend: {
                noColumns: 2,
                show: true,
                container: '#legendResponseTimesOverTime'
            },
            selection: {
                mode: 'xy'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to
                                // work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s : at %x Average response time was %y ms"
            }
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesResponseTimesOverTime"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotResponseTimesOverTime"), dataset, options);
        // setup overview
        $.plot($("#overviewResponseTimesOverTime"), dataset, prepareOverviewOptions(options));
    }
};

// Response Times Over Time
function refreshResponseTimeOverTime(fixTimestamps) {
    var infos = responseTimesOverTimeInfos;
    prepareSeries(infos.data);
    if (infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyResponseTimeOverTime");
        return;
    }
    if (fixTimestamps) {
        fixTimeStamps(infos.data.result.series, 28800000);
    }
    if (isGraph($("#flotResponseTimesOverTime"))) {
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesResponseTimesOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimesOverTime", "#overviewResponseTimesOverTime");
        $('#footerResponseTimesOverTime .legendColorBox > div').each(function (i) {
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var latenciesOverTimeInfos = {
    data: {
        "result": {
            "minY": 276.90000000000003,
            "minX": 1.64907222E12,
            "maxY": 276.90000000000003,
            "series": [{
                "data": [[1.64907222E12, 276.90000000000003]],
                "isOverall": false,
                "label": "HTTP请求",
                "isController": false
            }],
            "supportsControllersDiscrimination": true,
            "granularity": 60000,
            "maxX": 1.64907222E12,
            "title": "Latencies Over Time"
        }
    },
    getOptions: function () {
        return {
            series: {
                lines: {
                    show: true
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                mode: "time",
                timeformat: getTimeFormat(this.data.result.granularity),
                axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Average response latencies in ms",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            legend: {
                noColumns: 2,
                show: true,
                container: '#legendLatenciesOverTime'
            },
            selection: {
                mode: 'xy'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to
                                // work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s : at %x Average latency was %y ms"
            }
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesLatenciesOverTime"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotLatenciesOverTime"), dataset, options);
        // setup overview
        $.plot($("#overviewLatenciesOverTime"), dataset, prepareOverviewOptions(options));
    }
};

// Latencies Over Time
function refreshLatenciesOverTime(fixTimestamps) {
    var infos = latenciesOverTimeInfos;
    prepareSeries(infos.data);
    if (infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyLatenciesOverTime");
        return;
    }
    if (fixTimestamps) {
        fixTimeStamps(infos.data.result.series, 28800000);
    }
    if (isGraph($("#flotLatenciesOverTime"))) {
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesLatenciesOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotLatenciesOverTime", "#overviewLatenciesOverTime");
        $('#footerLatenciesOverTime .legendColorBox > div').each(function (i) {
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var connectTimeOverTimeInfos = {
    data: {
        "result": {
            "minY": 189.79,
            "minX": 1.64907222E12,
            "maxY": 189.79,
            "series": [{
                "data": [[1.64907222E12, 189.79]],
                "isOverall": false,
                "label": "HTTP请求",
                "isController": false
            }],
            "supportsControllersDiscrimination": true,
            "granularity": 60000,
            "maxX": 1.64907222E12,
            "title": "Connect Time Over Time"
        }
    },
    getOptions: function () {
        return {
            series: {
                lines: {
                    show: true
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                mode: "time",
                timeformat: getTimeFormat(this.data.result.granularity),
                axisLabel: getConnectTimeLabel(this.data.result.granularity),
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Average Connect Time in ms",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            legend: {
                noColumns: 2,
                show: true,
                container: '#legendConnectTimeOverTime'
            },
            selection: {
                mode: 'xy'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to
                                // work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s : at %x Average connect time was %y ms"
            }
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesConnectTimeOverTime"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotConnectTimeOverTime"), dataset, options);
        // setup overview
        $.plot($("#overviewConnectTimeOverTime"), dataset, prepareOverviewOptions(options));
    }
};

// Connect Time Over Time
function refreshConnectTimeOverTime(fixTimestamps) {
    var infos = connectTimeOverTimeInfos;
    prepareSeries(infos.data);
    if (infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyConnectTimeOverTime");
        return;
    }
    if (fixTimestamps) {
        fixTimeStamps(infos.data.result.series, 28800000);
    }
    if (isGraph($("#flotConnectTimeOverTime"))) {
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesConnectTimeOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotConnectTimeOverTime", "#overviewConnectTimeOverTime");
        $('#footerConnectTimeOverTime .legendColorBox > div').each(function (i) {
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var responseTimePercentilesOverTimeInfos = {
    data: {
        "result": {
            "minY": 237.0,
            "minX": 1.64907222E12,
            "maxY": 422.0,
            "series": [{
                "data": [[1.64907222E12, 422.0]],
                "isOverall": false,
                "label": "Max",
                "isController": false
            }, {
                "data": [[1.64907222E12, 300.0]],
                "isOverall": false,
                "label": "90th percentile",
                "isController": false
            }, {
                "data": [[1.64907222E12, 421.90999999999997]],
                "isOverall": false,
                "label": "99th percentile",
                "isController": false
            }, {
                "data": [[1.64907222E12, 311.95]],
                "isOverall": false,
                "label": "95th percentile",
                "isController": false
            }, {
                "data": [[1.64907222E12, 237.0]],
                "isOverall": false,
                "label": "Min",
                "isController": false
            }, {"data": [[1.64907222E12, 281.5]], "isOverall": false, "label": "Median", "isController": false}],
            "supportsControllersDiscrimination": false,
            "granularity": 60000,
            "maxX": 1.64907222E12,
            "title": "Response Time Percentiles Over Time (successful requests only)"
        }
    },
    getOptions: function () {
        return {
            series: {
                lines: {
                    show: true,
                    fill: true
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                mode: "time",
                timeformat: getTimeFormat(this.data.result.granularity),
                axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Response Time in ms",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            legend: {
                noColumns: 2,
                show: true,
                container: '#legendResponseTimePercentilesOverTime'
            },
            selection: {
                mode: 'xy'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to
                                // work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s : at %x Response time was %y ms"
            }
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesResponseTimePercentilesOverTime"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotResponseTimePercentilesOverTime"), dataset, options);
        // setup overview
        $.plot($("#overviewResponseTimePercentilesOverTime"), dataset, prepareOverviewOptions(options));
    }
};

// Response Time Percentiles Over Time
function refreshResponseTimePercentilesOverTime(fixTimestamps) {
    var infos = responseTimePercentilesOverTimeInfos;
    prepareSeries(infos.data);
    if (fixTimestamps) {
        fixTimeStamps(infos.data.result.series, 28800000);
    }
    if (isGraph($("#flotResponseTimePercentilesOverTime"))) {
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesResponseTimePercentilesOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimePercentilesOverTime", "#overviewResponseTimePercentilesOverTime");
        $('#footerResponseTimePercentilesOverTime .legendColorBox > div').each(function (i) {
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};


var responseTimeVsRequestInfos = {
    data: {
        "result": {
            "minY": 281.0,
            "minX": 3.0,
            "maxY": 413.0,
            "series": [{
                "data": [[97.0, 281.0], [3.0, 413.0]],
                "isOverall": false,
                "label": "Successes",
                "isController": false
            }],
            "supportsControllersDiscrimination": false,
            "granularity": 1000,
            "maxX": 97.0,
            "title": "Response Time Vs Request"
        }
    },
    getOptions: function () {
        return {
            series: {
                lines: {
                    show: false
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                axisLabel: "Global number of requests per second",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Median Response Time in ms",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            legend: {
                noColumns: 2,
                show: true,
                container: '#legendResponseTimeVsRequest'
            },
            selection: {
                mode: 'xy'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s : Median response time at %x req/s was %y ms"
            },
            colors: ["#9ACD32", "#FF6347"]
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesResponseTimeVsRequest"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotResponseTimeVsRequest"), dataset, options);
        // setup overview
        $.plot($("#overviewResponseTimeVsRequest"), dataset, prepareOverviewOptions(options));

    }
};

// Response Time vs Request
function refreshResponseTimeVsRequest() {
    var infos = responseTimeVsRequestInfos;
    prepareSeries(infos.data);
    if (isGraph($("#flotResponseTimeVsRequest"))) {
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesResponseTimeVsRequest");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimeVsRequest", "#overviewResponseTimeVsRequest");
        $('#footerResponseRimeVsRequest .legendColorBox > div').each(function (i) {
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};


var latenciesVsRequestInfos = {
    data: {
        "result": {
            "minY": 281.0,
            "minX": 3.0,
            "maxY": 413.0,
            "series": [{
                "data": [[97.0, 281.0], [3.0, 413.0]],
                "isOverall": false,
                "label": "Successes",
                "isController": false
            }],
            "supportsControllersDiscrimination": false,
            "granularity": 1000,
            "maxX": 97.0,
            "title": "Latencies Vs Request"
        }
    },
    getOptions: function () {
        return {
            series: {
                lines: {
                    show: false
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                axisLabel: "Global number of requests per second",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Median Latency in ms",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            legend: {noColumns: 2, show: true, container: '#legendLatencyVsRequest'},
            selection: {
                mode: 'xy'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s : Median Latency time at %x req/s was %y ms"
            },
            colors: ["#9ACD32", "#FF6347"]
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesLatencyVsRequest"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotLatenciesVsRequest"), dataset, options);
        // setup overview
        $.plot($("#overviewLatenciesVsRequest"), dataset, prepareOverviewOptions(options));
    }
};

// Latencies vs Request
function refreshLatenciesVsRequest() {
    var infos = latenciesVsRequestInfos;
    prepareSeries(infos.data);
    if (isGraph($("#flotLatenciesVsRequest"))) {
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesLatencyVsRequest");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotLatenciesVsRequest", "#overviewLatenciesVsRequest");
        $('#footerLatenciesVsRequest .legendColorBox > div').each(function (i) {
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var hitsPerSecondInfos = {
    data: {
        "result": {
            "minY": 1.6666666666666667,
            "minX": 1.64907222E12,
            "maxY": 1.6666666666666667,
            "series": [{
                "data": [[1.64907222E12, 1.6666666666666667]],
                "isOverall": false,
                "label": "hitsPerSecond",
                "isController": false
            }],
            "supportsControllersDiscrimination": false,
            "granularity": 60000,
            "maxX": 1.64907222E12,
            "title": "Hits Per Second"
        }
    },
    getOptions: function () {
        return {
            series: {
                lines: {
                    show: true
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                mode: "time",
                timeformat: getTimeFormat(this.data.result.granularity),
                axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Number of hits / sec",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20
            },
            legend: {
                noColumns: 2,
                show: true,
                container: "#legendHitsPerSecond"
            },
            selection: {
                mode: 'xy'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to
                                // work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s at %x was %y.2 hits/sec"
            }
        };
    },
    createGraph: function createGraph() {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesHitsPerSecond"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotHitsPerSecond"), dataset, options);
        // setup overview
        $.plot($("#overviewHitsPerSecond"), dataset, prepareOverviewOptions(options));
    }
};

// Hits per second
function refreshHitsPerSecond(fixTimestamps) {
    var infos = hitsPerSecondInfos;
    prepareSeries(infos.data);
    if (fixTimestamps) {
        fixTimeStamps(infos.data.result.series, 28800000);
    }
    if (isGraph($("#flotHitsPerSecond"))) {
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesHitsPerSecond");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotHitsPerSecond", "#overviewHitsPerSecond");
        $('#footerHitsPerSecond .legendColorBox > div').each(function (i) {
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
}

var codesPerSecondInfos = {
    data: {
        "result": {
            "minY": 1.6666666666666667,
            "minX": 1.64907222E12,
            "maxY": 1.6666666666666667,
            "series": [{
                "data": [[1.64907222E12, 1.6666666666666667]],
                "isOverall": false,
                "label": "200",
                "isController": false
            }],
            "supportsControllersDiscrimination": false,
            "granularity": 60000,
            "maxX": 1.64907222E12,
            "title": "Codes Per Second"
        }
    },
    getOptions: function () {
        return {
            series: {
                lines: {
                    show: true
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                mode: "time",
                timeformat: getTimeFormat(this.data.result.granularity),
                axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Number of responses / sec",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            legend: {
                noColumns: 2,
                show: true,
                container: "#legendCodesPerSecond"
            },
            selection: {
                mode: 'xy'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to
                                // work
            },
            tooltip: true,
            tooltipOpts: {
                content: "Number of Response Codes %s at %x was %y.2 responses / sec"
            }
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesCodesPerSecond"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotCodesPerSecond"), dataset, options);
        // setup overview
        $.plot($("#overviewCodesPerSecond"), dataset, prepareOverviewOptions(options));
    }
};

// Codes per second
function refreshCodesPerSecond(fixTimestamps) {
    var infos = codesPerSecondInfos;
    prepareSeries(infos.data);
    if (fixTimestamps) {
        fixTimeStamps(infos.data.result.series, 28800000);
    }
    if (isGraph($("#flotCodesPerSecond"))) {
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesCodesPerSecond");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotCodesPerSecond", "#overviewCodesPerSecond");
        $('#footerCodesPerSecond .legendColorBox > div').each(function (i) {
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var transactionsPerSecondInfos = {
    data: {
        "result": {
            "minY": 1.6666666666666667,
            "minX": 1.64907222E12,
            "maxY": 1.6666666666666667,
            "series": [{
                "data": [[1.64907222E12, 1.6666666666666667]],
                "isOverall": false,
                "label": "HTTP请求-success",
                "isController": false
            }],
            "supportsControllersDiscrimination": true,
            "granularity": 60000,
            "maxX": 1.64907222E12,
            "title": "Transactions Per Second"
        }
    },
    getOptions: function () {
        return {
            series: {
                lines: {
                    show: true
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                mode: "time",
                timeformat: getTimeFormat(this.data.result.granularity),
                axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Number of transactions / sec",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20
            },
            legend: {
                noColumns: 2,
                show: true,
                container: "#legendTransactionsPerSecond"
            },
            selection: {
                mode: 'xy'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to
                                // work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s at %x was %y transactions / sec"
            }
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesTransactionsPerSecond"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotTransactionsPerSecond"), dataset, options);
        // setup overview
        $.plot($("#overviewTransactionsPerSecond"), dataset, prepareOverviewOptions(options));
    }
};

// Transactions per second
function refreshTransactionsPerSecond(fixTimestamps) {
    var infos = transactionsPerSecondInfos;
    prepareSeries(infos.data);
    if (infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyTransactionsPerSecond");
        return;
    }
    if (fixTimestamps) {
        fixTimeStamps(infos.data.result.series, 28800000);
    }
    if (isGraph($("#flotTransactionsPerSecond"))) {
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesTransactionsPerSecond");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotTransactionsPerSecond", "#overviewTransactionsPerSecond");
        $('#footerTransactionsPerSecond .legendColorBox > div').each(function (i) {
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var totalTPSInfos = {
    data: {
        "result": {
            "minY": 1.6666666666666667,
            "minX": 1.64907222E12,
            "maxY": 1.6666666666666667,
            "series": [{
                "data": [[1.64907222E12, 1.6666666666666667]],
                "isOverall": false,
                "label": "Transaction-success",
                "isController": false
            }, {"data": [], "isOverall": false, "label": "Transaction-failure", "isController": false}],
            "supportsControllersDiscrimination": true,
            "granularity": 60000,
            "maxX": 1.64907222E12,
            "title": "Total Transactions Per Second"
        }
    },
    getOptions: function () {
        return {
            series: {
                lines: {
                    show: true
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                mode: "time",
                timeformat: getTimeFormat(this.data.result.granularity),
                axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Number of transactions / sec",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20
            },
            legend: {
                noColumns: 2,
                show: true,
                container: "#legendTotalTPS"
            },
            selection: {
                mode: 'xy'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to
                                // work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s at %x was %y transactions / sec"
            },
            colors: ["#9ACD32", "#FF6347"]
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesTotalTPS"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotTotalTPS"), dataset, options);
        // setup overview
        $.plot($("#overviewTotalTPS"), dataset, prepareOverviewOptions(options));
    }
};

// Total Transactions per second
function refreshTotalTPS(fixTimestamps) {
    var infos = totalTPSInfos;
    // We want to ignore seriesFilter
    prepareSeries(infos.data, false, true);
    if (fixTimestamps) {
        fixTimeStamps(infos.data.result.series, 28800000);
    }
    if (isGraph($("#flotTotalTPS"))) {
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesTotalTPS");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotTotalTPS", "#overviewTotalTPS");
        $('#footerTotalTPS .legendColorBox > div').each(function (i) {
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

// Collapse the graph matching the specified DOM element depending the collapsed
// status
function collapse(elem, collapsed) {
    if (collapsed) {
        $(elem).parent().find(".fa-chevron-up").removeClass("fa-chevron-up").addClass("fa-chevron-down");
    } else {
        $(elem).parent().find(".fa-chevron-down").removeClass("fa-chevron-down").addClass("fa-chevron-up");
        if (elem.id == "bodyBytesThroughputOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshBytesThroughputOverTime(true);
            }
            document.location.href = "#bytesThroughputOverTime";
        } else if (elem.id == "bodyLatenciesOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshLatenciesOverTime(true);
            }
            document.location.href = "#latenciesOverTime";
        } else if (elem.id == "bodyCustomGraph") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshCustomGraph(true);
            }
            document.location.href = "#responseCustomGraph";
        } else if (elem.id == "bodyConnectTimeOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshConnectTimeOverTime(true);
            }
            document.location.href = "#connectTimeOverTime";
        } else if (elem.id == "bodyResponseTimePercentilesOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshResponseTimePercentilesOverTime(true);
            }
            document.location.href = "#responseTimePercentilesOverTime";
        } else if (elem.id == "bodyResponseTimeDistribution") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshResponseTimeDistribution();
            }
            document.location.href = "#responseTimeDistribution";
        } else if (elem.id == "bodySyntheticResponseTimeDistribution") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshSyntheticResponseTimeDistribution();
            }
            document.location.href = "#syntheticResponseTimeDistribution";
        } else if (elem.id == "bodyActiveThreadsOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshActiveThreadsOverTime(true);
            }
            document.location.href = "#activeThreadsOverTime";
        } else if (elem.id == "bodyTimeVsThreads") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshTimeVsThreads();
            }
            document.location.href = "#timeVsThreads";
        } else if (elem.id == "bodyCodesPerSecond") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshCodesPerSecond(true);
            }
            document.location.href = "#codesPerSecond";
        } else if (elem.id == "bodyTransactionsPerSecond") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshTransactionsPerSecond(true);
            }
            document.location.href = "#transactionsPerSecond";
        } else if (elem.id == "bodyTotalTPS") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshTotalTPS(true);
            }
            document.location.href = "#totalTPS";
        } else if (elem.id == "bodyResponseTimeVsRequest") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshResponseTimeVsRequest();
            }
            document.location.href = "#responseTimeVsRequest";
        } else if (elem.id == "bodyLatenciesVsRequest") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshLatenciesVsRequest();
            }
            document.location.href = "#latencyVsRequest";
        }
    }
}

/*
 * Activates or deactivates all series of the specified graph (represented by id parameter)
 * depending on checked argument.
 */
function toggleAll(id, checked) {
    var placeholder = document.getElementById(id);

    var cases = $(placeholder).find(':checkbox');
    cases.prop('checked', checked);
    $(cases).parent().children().children().toggleClass("legend-disabled", !checked);

    var choiceContainer;
    if (id == "choicesBytesThroughputOverTime") {
        choiceContainer = $("#choicesBytesThroughputOverTime");
        refreshBytesThroughputOverTime(false);
    } else if (id == "choicesResponseTimesOverTime") {
        choiceContainer = $("#choicesResponseTimesOverTime");
        refreshResponseTimeOverTime(false);
    } else if (id == "choicesResponseCustomGraph") {
        choiceContainer = $("#choicesResponseCustomGraph");
        refreshCustomGraph(false);
    } else if (id == "choicesLatenciesOverTime") {
        choiceContainer = $("#choicesLatenciesOverTime");
        refreshLatenciesOverTime(false);
    } else if (id == "choicesConnectTimeOverTime") {
        choiceContainer = $("#choicesConnectTimeOverTime");
        refreshConnectTimeOverTime(false);
    } else if (id == "choicesResponseTimePercentilesOverTime") {
        choiceContainer = $("#choicesResponseTimePercentilesOverTime");
        refreshResponseTimePercentilesOverTime(false);
    } else if (id == "choicesResponseTimePercentiles") {
        choiceContainer = $("#choicesResponseTimePercentiles");
        refreshResponseTimePercentiles();
    } else if (id == "choicesActiveThreadsOverTime") {
        choiceContainer = $("#choicesActiveThreadsOverTime");
        refreshActiveThreadsOverTime(false);
    } else if (id == "choicesTimeVsThreads") {
        choiceContainer = $("#choicesTimeVsThreads");
        refreshTimeVsThreads();
    } else if (id == "choicesSyntheticResponseTimeDistribution") {
        choiceContainer = $("#choicesSyntheticResponseTimeDistribution");
        refreshSyntheticResponseTimeDistribution();
    } else if (id == "choicesResponseTimeDistribution") {
        choiceContainer = $("#choicesResponseTimeDistribution");
        refreshResponseTimeDistribution();
    } else if (id == "choicesHitsPerSecond") {
        choiceContainer = $("#choicesHitsPerSecond");
        refreshHitsPerSecond(false);
    } else if (id == "choicesCodesPerSecond") {
        choiceContainer = $("#choicesCodesPerSecond");
        refreshCodesPerSecond(false);
    } else if (id == "choicesTransactionsPerSecond") {
        choiceContainer = $("#choicesTransactionsPerSecond");
        refreshTransactionsPerSecond(false);
    } else if (id == "choicesTotalTPS") {
        choiceContainer = $("#choicesTotalTPS");
        refreshTotalTPS(false);
    } else if (id == "choicesResponseTimeVsRequest") {
        choiceContainer = $("#choicesResponseTimeVsRequest");
        refreshResponseTimeVsRequest();
    } else if (id == "choicesLatencyVsRequest") {
        choiceContainer = $("#choicesLatencyVsRequest");
        refreshLatenciesVsRequest();
    }
    var color = checked ? "black" : "#818181";
    if (choiceContainer != null) {
        choiceContainer.find("label").each(function () {
            this.style.color = color;
        });
    }
}

