root            /dev/null;
server_name     $hostname;

add_header X-Content-Type-Options nosniff always;
add_header X-Robots-Tag none always;
{{ if .wide_layout }}
sub_filter '</head>' '<style id="adguard-app-wide-layout">
@media (min-width:576px) {.container.container--wrap {max-width:calc(75% + 135px)}}
@media (min-width:768px) {.container.container--wrap {max-width:calc(75% + 180px)}}
@media (min-width:992px) {.container.container--wrap {max-width:calc(75% + 240px)}}
@media (min-width:1280px) {.container.container--wrap {max-width:calc(75% + 300px)}}
</style></head>';
{{ end }}
