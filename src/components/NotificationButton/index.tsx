import axios from 'axios';
import { toast } from 'react-toastify';
import icon from '../../assets/img/notification-icon.svg';
import { BASE_URL } from '../../utils/request';

import './styles.css';

type Props = {
  saleId: number;
}
// chama o id da venda quando der o click do botão 
function handleClick(id: number) {
  axios(`${BASE_URL}/sales/${id}/notification`)
  .then(response => {
    toast.info("SMS Enviado com sucesso");
  })
}

function NotificationButton( {saleId} : Props ) {
  return (
    <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)} >
      <img src={icon} alt="Notificar" />
    </div>
  )

}

export default NotificationButton;
