server {
    listen {{ .interface }}:{{ .port }} default_server;

    include /etc/nginx/includes/server_params.conf;
    include /etc/nginx/includes/proxy_params.conf;

    # Keep one quarter of the space left by AdGuard Home's stock width caps.
    sub_filter '</head>' '<style id="adguard-app-wide-layout">
    @media (min-width:576px) {.container.container--wrap {max-width:calc(75% + 135px)}}
    @media (min-width:768px) {.container.container--wrap {max-width:calc(75% + 180px)}}
    @media (min-width:992px) {.container.container--wrap {max-width:calc(75% + 240px)}}
    @media (min-width:1280px) {.container.container--wrap {max-width:calc(75% + 300px)}}
    </style></head>';

    location / {
        allow   172.30.32.2;
        deny    all;

        proxy_pass {{ .protocol }}://backend;
    }
}
