
// var gulp         = require('gulp');
// var uglify=require ("gulp-uglify"); //获取gulp-ublify组建
// var concat = require ("gulp-concat");

// gulp.task("script", function(){
//     gulp.src("js/*.js") //找到js文件夹下的所有js
//            .pipe(uglify()) //压缩文件
//            .pipe(concat('lib.min.js'))
//            .pipe(gulp.dest("dist/js")) //压缩完成后的文件另存到dist/js/目录下
// }); 

var gulp         = require('gulp'),
    clean        = require('gulp-clean'),
    uglify       = require('gulp-uglify'),
    rename       = require('gulp-rename'),
    changed      = require('gulp-changed'),
    sourcemaps   = require('gulp-sourcemaps'),
    pump         = require('pump'),
    sequence     = require('run-sequence');
var concat = require ("gulp-concat");
var config = {
    src: "js",
    dist: "dist"
}


/**
 * 清理目标目录
 */
gulp.task('clean', function(cb) {
    pump([
        gulp.src(config.dist),
        clean()
    ], cb)
})

/**
 * 执行JS压缩
 */
gulp.task('minify:js', [], function(cb) {
    pump([
        // 获取原目录下所有的js文件
        gulp.src(config.src + "/*.js"),
        // gulp.src(config.src + "/**/*.js"),
        // 执行更名操作
        // rename({ suffix: '.min' }),
        // 每次打包时，只打包内容发生改变的文件
        // changed(config.dist, { extension:'.js' }),
        // 生成sourcemap，需要配合后面的sourcemaps.write()
        sourcemaps.init(),
        // 执行JS压缩
        uglify(),
        // 生成sourcemap
        sourcemaps.write(),
        concat('lib.min.js'),
        // 输出至目标目录
        gulp.dest(config.dist)
    ], cb);
});

/**
 * 监听JS文件变改，即时调用任务执行JS增量打包
 */
gulp.task('watch', [], function(cb) {
    gulp.watch(config.src + "/*.js", ['minify:js']);
});

/**
 * 开始执行
 */
gulp.task('default', function(cb) {
    sequence('clean', 'minify:js', 'watch', cb);
});
