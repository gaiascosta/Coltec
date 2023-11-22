const APIController = (function() {
    const clientId = '0ff466d7cd3f468992a9d5aefbcc6edc';
    const clientSecret = '325b665a30ed4c2b998a3c72c8a8c82d';

    const _getToken = async () => {
        const response = await fetch('https://accounts.spotify.com/api/token', {
            method: 'POST',
            headers: {
                'Content-Type' : 'application/x-www-form-urlencoded', 
                'Authorization' : 'Basic ' + btoa(clientId + ':' + clientSecret)
            },
            body: 'grant_type=client_credentials'
        });
        return (await response.json()).access_token;
    }

    const _getGenres = async (token) => {
        const response = await fetch(`https://api.spotify.com/v1/browse/categories?locale=sv_US`, {
            method: 'GET',
            headers: { 'Authorization' : 'Bearer ' + token}
        });
        return (await response.json()).categories.items;
    }

    const _getPlaylistByGenre = async (token, genreId) => {
        const response = await fetch(`https://api.spotify.com/v1/browse/categories/${genreId}/playlists`, {
            method: 'GET',
            headers: { 'Authorization' : 'Bearer ' + token}
        });
        return (await response.json()).playlists.items;
    }

    const _getTracks = async (token, tracksEndPoint) => {
        const response = await fetch(`${tracksEndPoint}`, {
            method: 'GET',
            headers: { 'Authorization' : 'Bearer ' + token}
        });
        return (await response.json()).items;
    }

    const _getTrack = async (token, trackEndPoint) => {
        const result = await fetch(`${trackEndPoint}`, {
            method: 'GET',
            headers: { 'Authorization' : 'Bearer ' + token}
        });
        return (await result.json());
    }

    return {
        getToken(){return _getToken();},
        getGenres(token){return _getGenres(token);},
        getPlaylistByGenre(token, genreId){return _getPlaylistByGenre(token, genreId);},
        getTracks(token, tracksEndPoint){return _getTracks(token, tracksEndPoint);},
        getTrack(token, trackEndPoint){return _getTrack(token, trackEndPoint);}
    }
})();

const UIController = (function() {
    const DOMElements = {
        selectGenre: '#select_genre',
        selectPlaylist: '#select_playlist',
        selectTrack: '#select_track',
        buttonSubmit: '#btn_submit',
        divSongDetail: '#song-detail',
        hfToken: '#hidden_token',
    }
    return {
        inputField() {
            return {
                genre: document.querySelector(DOMElements.selectGenre),
                playlist: document.querySelector(DOMElements.selectPlaylist),
                tracks: document.querySelector(DOMElements.selectTrack),
                submit: document.querySelector(DOMElements.buttonSubmit),
                songDetail: document.querySelector(DOMElements.divSongDetail)
            }
        },
        createGenre(text, value) {
            const html = `<option value="${value}">${text}</option>`;
            document.querySelector(DOMElements.selectGenre).insertAdjacentHTML('beforeend', html);
        }, 
        createPlaylist(text, value) {
            const html = `<option value="${value}">${text}</option>`;
            document.querySelector(DOMElements.selectPlaylist).insertAdjacentHTML('beforeend', html);
        },
        createTrack(text, value) {
            const html = `<option value="${value}">${text}</option>`;
            document.querySelector(DOMElements.selectTrack).insertAdjacentHTML('beforeend', html);
        },
        createTrackDetail(img, title, artist) {
            const detailDiv = document.querySelector(DOMElements.divSongDetail);
            detailDiv.innerHTML = '';
            const html = 
            `
            <div >
                <img src="${img}" alt="">        
            </div>
            <div class="row">
                <label for="Genre" class="form-label">${title}:</label>
            </div>
            <div class="row">
                <label for="artist" class="form-label">By ${artist}</label>
            </div> 
            `;

            detailDiv.insertAdjacentHTML('beforeend', html)
        },

        resetTracks() {
            this.inputField().tracks.innerHTML = '';
            this.inputField().songDetail.innerHTML = '';
        },

        resetPlaylist() {
            this.inputField().playlist.innerHTML = '';
            this.inputField().tracks.innerHTML = '';
            this.inputField().songDetail.innerHTML = '';
        },

        resetTrackDetail(){
            this.inputField().songDetail.innerHTML = '';
        },

        setStoredToken(value){
            document.querySelector(DOMElements.hfToken).value = value;
        },

        getStoredToken(){
            return {
                token: document.querySelector(DOMElements.hfToken).value
            }
        }
    }

})();

const APPController = (function(UICtrl, APICtrl) {
    const DOMInputs = UICtrl.inputField();

    const loadGenres = async () => {
        const token = await APICtrl.getToken();
        UICtrl.setStoredToken(token);
        const genres = await APICtrl.getGenres(token);
        genres.forEach(element => UICtrl.createGenre(element.name, element.id));
    }

    DOMInputs.genre.addEventListener('change', async () => {
        //reseta a playlist para aparecer a primeira
        UICtrl.resetPlaylist();
        const token = UICtrl.getStoredToken().token;
        const genreSelect = UICtrl.inputField().genre;
        const genreId = genreSelect.options[genreSelect.selectedIndex].value;
        const playlist = await APICtrl.getPlaylistByGenre(token, genreId);
        playlist.forEach(p => UICtrl.createPlaylist(p.name, p.tracks.href));
    });

    DOMInputs.playlist.addEventListener('change', async () => {
        //reseta a música para aparecer a primeira
        UICtrl.resetTracks();
        const token = UICtrl.getStoredToken().token;
        const playlistSelect = UICtrl.inputField().playlist;
        const tracksEndPoint = playlistSelect.options[playlistSelect.selectedIndex].value;
        const tracks = await APICtrl.getTracks(token, tracksEndPoint);
        tracks.forEach(el => UICtrl.createTrack(el.track.name, el.track.href))
    });

    DOMInputs.submit.addEventListener('click', async (e) => {
        //imprime os detalhes da musica escolhida
        e.preventDefault();
        UICtrl.resetTrackDetail();
        const token = UICtrl.getStoredToken().token;
        const trackSelect = UICtrl.inputField().tracks;
        const trackEndpoint = trackSelect.options[trackSelect.selectedIndex].value;
        const track = await APICtrl.getTrack(token, trackEndpoint);
        UICtrl.createTrackDetail(track.album.images[2].url, track.name, track.artists[0].name);
    });    

    return {
        init() {
            console.log('App is starting');
            loadGenres();
        }
    }

})(UIController, APIController);

APPController.init();