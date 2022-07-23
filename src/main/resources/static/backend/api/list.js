const list = () => {
    return $axios({
        url: '/list/list',
        method: 'get'
    })
}